package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/08/30
 * 외판원 순회2 Review.
 */
public class BOJ10971RE {
    private static int N;
    private static int[][] map;
    private static boolean[] visit;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = toInt(in[j]);
            }
        }

        // 출발한 도시를 start 에 저장한다.
        int start;
        for (int i = 0; i < N; i++) {
            start = i;
            dfs(start, i, 0, 0);
        }
        System.out.println(min);
    }

    // start : 시작한 도시, num : 방문할 도시, count : 방문한 도시의 갯수, total : 도시를 방문한 비용의 합.
    private static void dfs(int start, int num, int count, int total) {
        // 종료 조건은 N개의 도시를 다 돌았고, 시작했던 지점으로 다시 돌아오는 경우이다.
        if (count == N && start == num) {
            min = Math.min(min, total);
            return;
        }

        // 다음 도시를 방문한다.
        for (int i = 0; i < N; i++) {
            // 자기 자신의 정점은 0이므로 자기 자신이라면 건너뛴다.
            if (map[num][i] == 0) continue;

            // 방문한 적이 없고, 현재 자기 자신이 아니라면 방문할 수 있다.
            // map[num][i]는 현재 num 도시에서 자기 자신을 제외하고 갈 수 있는 도시들이다.
            // num 이 0이라면 0번 도시에 연결된 1,2,3들이 올 수 있다.
            if (!visit[i] && map[num][i] != 0) {
                visit[i] = true;
                total += map[num][i];

                // min 에는 최소 비용이 업데이트 되어 저장된다.
                // 하지만, total < min 의 경우에만 dfs 재귀 호출을 하면 시간이 절약될 수 있다.
                // 클 경우, 호출하지 않기 때문에 함수 호출이 깊어지지 않을 수 있다.
                if (total < min) dfs(start, i, count + 1, total);

                // 백트래킹.
                visit[i] = false;
                total -= map[num][i];
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
