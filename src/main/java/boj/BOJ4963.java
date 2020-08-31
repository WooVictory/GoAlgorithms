package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/31
 */
public class BOJ4963 {
    private static int[][] map;
    private static boolean[][] visit;
    private static int h, w;
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String[] in = br.readLine().split(" ");
            w = toInt(in[0]);
            h = toInt(in[1]);
            if (isZero(w, h)) break;

            map = new int[h][w];
            visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                in = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = toInt(in[j]);
                }
            }
            solve(h, w);
        }
    }

    private static void solve(int h, int w) {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    count++;
                    //bfs(i, j);
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        if (visit[x][y]) return;

        visit[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;

            if (!visit[nx][ny] && map[nx][ny] == 1) dfs(nx, ny);
        }
    }

    private static void bfs(int x, int y) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.remove();
            x = now.x;
            y = now.y;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;

                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    private static boolean isZero(int a, int b) {
        return a == 0 && b == 0;
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
