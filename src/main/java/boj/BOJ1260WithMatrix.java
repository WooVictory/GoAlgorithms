package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/25
 * 인접 행렬을 사용했을 경우!
 */
public class BOJ1260WithMatrix {
    private static int[][] a;
    private static boolean[] visit;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] in = bf.readLine().split(" ");
        N = toInt(in[0]);
        M = toInt(in[1]);
        int start = toInt(in[2]);

        a = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            in = bf.readLine().split(" ");
            int v1 = toInt(in[0]);
            int v2 = toInt(in[1]);

            a[v1][v2] = 1;
            a[v2][v1] = 1;
        }

        dfs(start);
        System.out.println();
        visit = new boolean[N + 1];
        bfs(start);
    }

    private static void dfs(int v) {
        if (visit[v]) return;

        visit[v] = true;
        System.out.print(v+" ");
        for (int i = 0; i <= N; i++) {
            if (!visit[i] && a[v][i] == 1) dfs(i);
        }
    }

    private static void bfs(int v) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();
            System.out.print(cur + " ");

            // 현재 바라보고 있는 행의 모든 열을 확인한다.
            // 즉, 현재 정점과 연결된 정점이 있는지 모두 확인한다.
            for (int i = 1; i <= N; i++) {
                if (!visit[i] && a[v][i] == 1) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
