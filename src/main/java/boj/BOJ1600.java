package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/02
 */
public class BOJ1600 {
    private static int w, h;
    private static int[][] map;
    private static boolean[][][] visit;
    private static int[] horseDx = {-1, -2, -1, -2, 1, 1, 2, 2};
    private static int[] horseDy = {-2, -1, 2, 1, -2, 2, -1, 1};
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = toInt(br.readLine());
        String[] in = br.readLine().split(" ");
        w = toInt(in[0]);
        h = toInt(in[1]);

        map = new int[h][w];
        visit = new boolean[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                map[i][j] = toInt(in[j]);
            }
        }

        bfs(k);
        System.out.println(result);
    }

    // 특정 위치로 이동했을 때, 나이트 이동을 해서 간 것과 나이트 이동을 하지 않고 간 것은 다르다.
    // 따라서 특정 위치에서 나이트 이동이 몇 개 남았는지를 기준으로 visit 배열을 구성한다.
    // visit[x][y][가능한 나이트 이동의 개수 k]
    private static void bfs(int k) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, k));
        visit[0][0][k] = true;

        while (!q.isEmpty()) {
            Node now = q.remove();
            int x = now.x, y = now.y, count = now.count, horseK = now.horseK;

            // (h,w)인 도착 지점에 도착하면 카운트 저장하고 종료.
            if (x == h - 1 && y == w - 1) {
                result = count;
                return;
            }

            // 원숭이의 일반적인 이동.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx, ny) || visit[nx][ny][horseK] || map[nx][ny] == 1) continue;

                visit[nx][ny][horseK] = true;
                q.add(new Node(nx, ny, count + 1, horseK));
            }

            // 나이트 이동을 다 쓴 경우.
            if (horseK == 0) continue;

            // 원숭이가 말처럼 이동(나이트 이동)
            for (int i = 0; i < 8; i++) {
                int nx = x + horseDx[i];
                int ny = y + horseDy[i];

                if (!isRange(nx, ny) || visit[nx][ny][horseK - 1] || map[nx][ny] == 1) continue;

                visit[nx][ny][horseK - 1] = true;
                q.add(new Node(nx, ny, count + 1, horseK - 1));
            }
        }
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < h && 0 <= y && y < w;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int x;
        int y;
        int count;
        int horseK;

        Node(int x, int y, int count, int horseK) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.horseK = horseK;
        }
    }
}