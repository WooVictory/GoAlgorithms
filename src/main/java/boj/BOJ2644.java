package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/28
 */
public class BOJ2644 {
    private static ArrayList<Integer>[] a;
    private static boolean[] visit;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = toInt(br.readLine());
        a = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) a[i] = new ArrayList<>();

        String[] in = br.readLine().split(" ");
        int x = toInt(in[0]);
        int y = toInt(in[1]);

        int m = toInt(br.readLine());
        while (m-- > 0) {
            in = br.readLine().split(" ");
            int v1 = toInt(in[0]), v2 = toInt(in[1]);

            a[v1].add(v2);
            a[v2].add(v1);
        }

        bfs(x);
        System.out.println(distance[y] == 0 ? -1 : distance[y]);
    }

    private static void bfs(int start) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        distance[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.remove();

            for (int v : a[cur]) {
                if (!visit[v]) {
                    q.add(v);
                    visit[v] = true;
                    distance[v] = distance[cur] + 1;
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}