package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/26
 */
public class BOJ10451 {
    private static int[] a;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = toInt(br.readLine());
        while (N-- > 0) {
            int t = toInt(br.readLine());
            a = new int[t + 1];
            visit = new boolean[t + 1];

            String[] in = br.readLine().split(" ");

            for (int i = 1; i <= t; i++) a[i] = toInt(in[i - 1]);

            int answer = 0;
            for (int i = 1; i <= t; i++) {
                if (!visit[i]) {
                    answer++;
                    //bfs(i);
                    dfs(i);
                }
            }

            System.out.println(answer);
        }
    }

    private static void dfs(int v) {
        if (visit[v]) return;

        visit[v] = true;
        int vv = a[v];
        if (!visit[vv]) dfs(vv);
    }

    private static void bfs(int v) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();
            int value = a[cur];

            if (!visit[value] && value != 0) {
                q.add(value);
                visit[value] = true;
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
