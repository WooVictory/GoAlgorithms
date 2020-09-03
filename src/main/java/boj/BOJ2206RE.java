package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/03
 */
public class BOJ2206RE {
    private static int n, m;
    private static int[][] map;
    private static boolean[][][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = toInt(in[0]);
        m = toInt(in[1]);

        map = new int[n][m];
        visit = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(result);
    }

    private static int result = -1;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static void bfs() {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            int x = cur.x, y = cur.y, count = cur.count, distance = cur.distance;

            if (x == n - 1 && y == m - 1) {
                result = distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 0 -> count 로 바꿔줘야 한다.
                // 처음에는 0으로 무조건 고정했었다. 테케는 맞지만, 실제로는 틀렸다.
                // 예를 들어서
                // (1,1) -> (2,1) 로 이동하면서 벽을 부수지 않고 이동했다면 visit[2][1][0]=true
                // (2,3) -> (2,1) 로 이동하면서 이전에 벽을 부순 상태에서 이동해왔다면 visit[2][1][1]=true
                // 이렇게 결과가 나와야 하기 때문에 무조건 다음에 갈 좌표가 벽을 부수지 않았다고 판단하여 0으로 세팅하는 것은 잘못되었다.
                // 이전에 벽을 부수었는지 아닌지 값을 들고 있는 count 가 들어가야 한다.
                if (map[nx][ny] == 0) {
                    if (!visit[nx][ny][count]) {
                        visit[nx][ny][count] = true;
                        q.add(new Node(nx, ny, count, distance + 1));
                    }
                } else if (map[nx][ny] == 1){
                    if (count == 0 && !visit[nx][ny][count + 1]) {
                        visit[nx][ny][count + 1] = true;
                        q.add(new Node(nx, ny, count + 1, distance + 1));
                    }
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int x;
        int y;
        int count;
        int distance;

        Node(int x, int y, int count, int distance) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.distance = distance;
        }
    }
}
