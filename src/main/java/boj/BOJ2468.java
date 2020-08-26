package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/26
 */
public class BOJ2468 {
    private static int N;
    private static int[][] map;
    private static boolean[][] visit;
    private static int result = 0;
    private static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(br.readLine());

        map = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = toInt(in[j]);
                if (max < map[i][j]) max = map[i][j];
            }
        }

        // 입력받은 높이 중 가장 높은 높이를 시작으로 하여 물을 채우면서
        // 높이를 줄여나간다.
        while (max-- > 0) {
            System.out.println(max);
            visit = new boolean[N][N];
            int count = 0;

            // max 이하인 지점을 물을 미리 채운다.
            // 물이 찬 지점은 visit 배열의 값이 true.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= max) visit[i][j] = true;
                }
            }

            // 위에서 미리 물을 채웠으므로, 물이 채워져있지 않은 안전영역만 탐색하며 갯수를 센다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        count++;
                        //bfs(i, j);
                        dfs(i, j);
                    }
                }
            }

            // 갯수 중 가장 큰 안전영역의 갯수가 몇개인지 result 값에 업데이트한다.
            if (result < count) result = count;
        }
        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (!visit[nx][ny]) dfs(nx, ny);
        }
    }

    private static void bfs(int x, int y) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            x = cur.x;
            y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (!visit[nx][ny]) {
                    q.add(new Node(nx, ny));
                    visit[nx][ny] = true;
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

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
