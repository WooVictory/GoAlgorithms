package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/09/25
 */
public class BOJ1987RE3 {
    private static char[][] map;
    private static int r, c;
    private static boolean[] visit;
    private static int max = 1, count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        r = toInt(in[0]);
        c = toInt(in[1]);

        map = new char[r][c];
        visit = new boolean[26];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static void dfs(int x, int y) {
        int alpha = map[x][y] - 'A';
        if (visit[alpha]) return;

        visit[alpha] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

            int newAlpha = map[nx][ny] - 'A';
            if (!visit[newAlpha]) {
                count++;
                if (max < count) max = count;
                dfs(nx, ny);
            }
        }

        count--;
        visit[alpha] = false;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}