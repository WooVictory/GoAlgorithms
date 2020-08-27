package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/27
 */
public class BOJ11724 {
    private static int N, M;
    private static ArrayList<Integer>[] a;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = toInt(in[0]);
        M = toInt(in[1]);

        a = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) a[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int v = toInt(in[0]), vv = toInt(in[1]);

            a[v].add(vv);
            a[vv].add(v);
        }

        //for (int i = 0; i <= N; i++) Collections.sort(a[i]);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                answer++;
                bfs(i);
                //dfs(i);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int v) {
        if (visit[v]) return;
        visit[v] = true;

        for (int vv : a[v]) {
            if (!visit[vv]) dfs(vv);
        }
    }

    private static void bfs(int v) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();

            System.out.print(cur + " - ");

            for (int vv : a[cur]) {
                if (!visit[vv]) {
                    visit[vv] = true;
                    q.add(vv);
                }
            }
        }

        System.out.println();
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
