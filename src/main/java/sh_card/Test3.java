package sh_card;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/09/09
 * 3번 문제.
 * 최소 금액을 찾기 위해 bfs 탐색으로 접근했지만, 가중치가 존재하여 제대로 접근이 불가능했다.
 * 또한, 넓게 탐색하기보다는 깊게 탐색하여 갈 수 있는 도착점까지 가서 최소의 금액을 찾도록 해주었다.
 * dfs + 백트래킹.
 */
public class Test3 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 1000},
                {1, 5, 2000},
                {2, 3, 3000},
                {2, 4, 1500},
                {3, 4, 1000},
                {4, 5, 2000}
        };

        solution(5, arr, 3);
    }

    private static boolean[] visit;
    private static int[][] distance;
    private static ArrayList<Integer>[] a;
    private static int min = Integer.MAX_VALUE;

    private static void solution(int N, int[][] fees, int dest) {
        visit = new boolean[N + 1];
        distance = new int[N + 1][N + 1];
        a = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) a[i] = new ArrayList<>();

        for (int[] info : fees) {
            int v1 = info[0], v2 = info[1], fee = info[2];
            a[v1].add(v2);
            a[v2].add(v1);

            distance[v1][v2] = distance[v2][v1] = fee;
        }

        visit[1] = true;
        dfs(1, 0, dest);
        System.out.println(min);
    }

    private static void dfs(int v, int total, int dest) {
        if (v == dest) {
            min = Math.min(min, total);
            return;
        }

        for (int vv : a[v]) {
            if (!visit[vv]) {
                visit[vv] = true;
                dfs(vv, total + distance[v][vv], dest);
                visit[vv] = false;
            }
        }
    }
}