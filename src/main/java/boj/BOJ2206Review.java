package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/04
 */
public class BOJ2206Review {
    private static int N, M;
    private static int[][] map;
    private static boolean[][][] visit;
    private static int result = -1;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = toInt(in[0]);
        M = toInt(in[1]);

        map = new int[N][M];
        visit = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            int x = cur.x, y = cur.y, count = cur.count, distance = cur.distance;

            if (x == N - 1 && y == M - 1) {
                result = distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0) {
                    if (!visit[nx][ny][count]) {
                        visit[nx][ny][count] = true;
                        q.add(new Node(nx, ny, count, distance + 1));
                    }
                } else {
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