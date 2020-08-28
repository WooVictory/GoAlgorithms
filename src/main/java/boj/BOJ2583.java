package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/28
 */
public class BOJ2583 {
    private static int M, N, K;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static ArrayList<Integer> result = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        M = toInt(in[0]);
        N = toInt(in[1]);
        K = toInt(in[2]);

        map = new int[M][N];
        visit = new boolean[M][N];

        while (K-- > 0) {
            in = br.readLine().split(" ");
            int lx = toInt(in[0]), ly = toInt(in[1]);
            int rx = toInt(in[2]), ry = toInt(in[3]);

            draw(ly, lx, ry - 1, rx - 1);
            //print(map);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 9 && !visit[i][j]) {
                    answer++;
                    count = 0;
                    //bfs(i, j);
                    dfs(i, j);

                    result.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) sb.append(result.get(i));
            else sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            x = cur.x;
            y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (visit[nx][ny]) continue;

                if (map[nx][ny] != 9) {
                    count++;
                    q.add(new Node(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }

        result.add(count);
    }

    private static void dfs(int x, int y) {
        count++;
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (visit[nx][ny]) continue;

            if (map[nx][ny] != 9) {
                visit[nx][ny] = true;
                dfs(nx, ny);
            }

        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print(int[][] a) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void draw(int lx, int ly, int rx, int ry) {
        //System.out.println(lx + ", " + ly);
        //System.out.println(rx + ", " + ry);
        for (int i = lx; i <= rx; i++) {
            for (int j = ly; j <= ry; j++) {
                map[i][j] = 9;
                visit[i][j] = true;
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
