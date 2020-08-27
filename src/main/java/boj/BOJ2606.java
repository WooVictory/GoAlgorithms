package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/27
 */
public class BOJ2606 {
    private static ArrayList<Integer>[] a;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = toInt(br.readLine());
        a = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) a[i] = new ArrayList<>();

        int m = toInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] in = br.readLine().split(" ");
            int v1 = toInt(in[0]), v2 = toInt(in[1]);

            a[v1].add(v2);
            a[v2].add(v1);
        }

        //bfs();
        dfs(1);
        System.out.println(answer);
    }

    private static int answer = 0;

    private static void dfs(int v) {
        if (visit[v]) return;

        visit[v] = true;
        for (int vv : a[v]) {
            if (!visit[vv]) {
                answer++;
                dfs(vv);
            }
        }
    }

    private static void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.remove();

            for (int v : a[cur]) {
                if (!visit[v]) {
                    count++;
                    q.add(v);
                    visit[v] = true;
                }
            }
        }

        System.out.println(count);
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

}
