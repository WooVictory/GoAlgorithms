package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/25
 * 인접 리스트를 사용했을 때!
 */
public class BOJ1260WithList {
    private static ArrayList<Integer>[] map;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] in = bf.readLine().split(" ");
        int N = toInt(in[0]);
        int M = toInt(in[1]);
        int start = toInt(in[2]);

        map = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            in = bf.readLine().split(" ");
            int v1 = toInt(in[0]);
            int v2 = toInt(in[1]);

            map[v1].add(v2);
            map[v2].add(v1);
        }

        for (int i = 0; i <= N; i++) Collections.sort(map[i]);

        dfs(start);

        System.out.println();
        visit = new boolean[N + 1];

        bfs(start);
    }

    private static void bfs(int start) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();
            System.out.print(cur + " ");
            for (int vv : map[cur]) {
                if (!visit[vv]) {
                    visit[vv] = true;
                    q.add(vv);
                }
            }
        }
    }

    private static void dfs(int v) {
        if (visit[v]) return;

        visit[v] = true;
        System.out.print(v + " ");
        for (int vv : map[v]) {
            if (!visit[vv]) dfs(vv);
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
