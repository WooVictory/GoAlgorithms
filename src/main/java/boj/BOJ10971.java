package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/08/27
 */
public class BOJ10971 {
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

        // 시작점.
        int start;
        for (int i = 0; i < N; i++) {
            start = i;
            // dfs 탐색을 진행한다.
            dfs(start, i, 0, 0);
        }

        System.out.println(min);
    }


    private static void dfs(int start, int num, int count, int total) {
        // 종료조건은 N개의 도시를 모두 방문하고, 다시 시작점으로 돌아왔을 경우이다.
        if (count == N && start == num) {
            // 최소 비용을 갱신한다.
            min = Math.min(min, total);
            return;
        }

        // N까지 돌면서 다시 확인한다.
        for (int i = 0; i < N; i++) {
            // 0인 곳은 자기 자신의 정점이기 때문에 건너뛴다.
            if (map[num][i] == 0) continue;

            // 방문한 적이 없고 0이 아닌 경우에 대해서 확인한다.
            // 방문 체크를 하고 total 에 비용을 누적한다.
            // 백트래킹이므로 방문 체크를 해제하고, 비용을 빼준다.
            if (!visit[num] && 0 < map[num][i]) {
                visit[num] = true;
                total += map[num][i];

                // if 문이 없는 경우 : 2600ms
                // if 문이 있는 경우 : 120ms
                // 굳이 min 보다 큰 total 에 대해서 다시 탐색할 필요가 없다.
                // 어차피 위에서 조건문으로 걸러지기 때문에 total < min 일 때만 dfs 재귀 호출을 진행한다.
                if (total < min) dfs(start, i, count + 1, total);

                // 백트래킹.
                visit[num] = false;
                total -= map[num][i];
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}