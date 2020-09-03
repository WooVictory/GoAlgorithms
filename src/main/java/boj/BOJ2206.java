package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/03
 */
public class BOJ2206 {
    private static int n, m;
    private static int[][] map;
    private static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = toInt(in[0]);
        m = toInt(in[1]);

        map = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(answer);
    }

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int answer = -1;

    private static void bfs() {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
        visit[0][0] = 0; // 공사횟수.

        while (!q.isEmpty()) {
            Node cur = q.remove();
            int x = cur.x, y = cur.y, count = cur.count, distance = cur.distance;

            if (x == n - 1 && y == m - 1) {
                answer = distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 만약, 다음에 나온 공사횟수 값이 기존에 갖고 있던 값보다 작거나 같으면
                // 굳이 큐에 추가하지 않고 넘어가도 된다.
                if (visit[nx][ny] <= count) continue;

                // 벽이 아닐 때, 이동거리만 증가시켜주고, 공사횟수는 그대로이다.
                if (map[nx][ny] == 0) {
                    visit[nx][ny] = count;
                    q.add(new Node(nx, ny, count, distance + 1));
                } else {
                    // 벽일 때, 공사횟수가 0인 경우에만 진행할 수 있다.
                    // 즉, 이전에 공사를 안했던 상태에서만 이동거리와 공사횟수를 증가시켜서 큐에 넣는다.
                    if (count == 0) {
                        visit[nx][ny] = count + 1;
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
