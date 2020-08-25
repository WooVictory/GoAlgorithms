package programmers;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/25
 */
public class PGM43162 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int[][] aa = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        System.out.println(solution(3, a));
    }

    private static boolean[] visit;
    private static int[][] a;

    public static int solution(int n, int[][] map) {
        a = map;
        int answer = 0;
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer++;
                //dfs(i, n);
                bfs(i, n);
            }
        }
        return answer;
    }

    private static void dfs(int v, int n) {
        if (visit[v]) return;
        visit[v] = true;

        for (int i = 0; i < n; i++) {
            if (!visit[i] && a[v][i] == 1) dfs(i, n);
        }
    }

    private static void bfs(int v, int n) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();

            for (int i = 0; i < n; i++) {
                if (!visit[i] && a[cur][i] == 1) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
