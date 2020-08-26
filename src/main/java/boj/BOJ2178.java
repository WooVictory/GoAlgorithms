package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/26
 * 미로 탐색.
 */
public class BOJ2178 {
    private static int N, M;
    private static int[][] map;
    private static int[][] distance;
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = toInt(in[0]);
        M = toInt(in[1]);

        map = new int[N][M];
        distance = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) - 48;
            }
        }

        bfs();

        print(map);
        System.out.println();
        print(distance);
        System.out.println(distance[N - 1][M - 1]);
    }

    private static void bfs() {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visit[0][0] = true;
        distance[0][0] = 1;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    distance[nx][ny] = distance[x][y] + 1;
                    visit[nx][ny] = true;
                }
            }
        }
    }

    private static void print(int[][] a) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
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
