package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/09/01
 */
public class BOJ1987 {
    private static int r, c;
    private static int[][] a;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        r = toInt(in[0]);
        c = toInt(in[1]);

        a = new int[r][c];
        visit = new boolean[27];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j) - 65;
            }
        }

        // (0,0) 지점에 말이 위치하기 때문에 여기서부터 시작한다.
        dfs(0, 0);
        System.out.println(max);
    }

    private static int count = 1;
    private static int max = 1;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static void dfs(int x, int y) {
        // 알파벳을 인덱스로 처리하기 위해 a 배열에는 인덱스가 저장되어 있다. 65를 빼줌.
        int alphabet = a[x][y];
        if (visit[alphabet]) return;
        visit[alphabet] = true; // 방문 여부를 체크한다.

        // 상하좌우 네 방향을 탐색한다.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            int nextAlphabet = a[nx][ny];

            // 방문한 적이 없으면, count 증가시키고, max 값을 갱신한다.
            // 최대 몇 칸을 이동했는지 찾는다.
            // dfs 호출.
            if (!visit[nextAlphabet]) {
                count++;
                max = Math.max(max, count);
                dfs(nx, ny);
            }
        }

        // 백트래킹을 한다.
        // 카운트를 감소시키고, 방문 여부를 해제한다.
        // 여기서 하는 이유는 해당 정점에 대해서 한번만 해제하기 위함이다.
        // 위의 for 문 안에서 하게 되면 백트래킹으로 해제되면서 여러번 해제하려 하고, count 도 더 감소하여
        // 정확한 결과를 얻지 못할 것이다.
        count--;
        visit[alphabet] = false;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
