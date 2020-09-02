package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/09/02
 * 알파벳 Review.
 */
public class BOJ1987RE {
    private static int r, c;
    private static int[][] map;
    private static boolean[] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int count = 1, max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        r = toInt(in[0]);
        c = toInt(in[1]);

        map = new int[r][c];
        visit = new boolean[26]; // 알파벳의 중복 여부를 체크하기 위함.

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j) - 65;
            }
        }

        // (0,0)에 말이 위치하므로 여기서부터 시작!
        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int y) {
        int alpha = map[x][y];
        if (visit[alpha]) return;

        visit[alpha] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

            int nextAlpha = map[nx][ny];
            if (!visit[nextAlpha]) {
                count++;
                if (max < count) max = count;
                dfs(nx, ny);
            }
        }

        // 백트래킹을 해준다.
        // 카운트를 감소시키고, 방문 여부를 해제함으로써 다음에 방문할 수 있도록 해준다.
        count--;
        visit[alpha] = false;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
