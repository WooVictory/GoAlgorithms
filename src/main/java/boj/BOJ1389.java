package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/28
 */
public class BOJ1389 {
    private static int N, M;
    private static ArrayList<Integer>[] a;
    private static boolean[] visit;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = toInt(in[0]);
        M = toInt(in[1]);

        a = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) a[i] = new ArrayList<>();

        while (M-- > 0) {
            in = br.readLine().split(" ");
            int v1 = toInt(in[0]), v2 = toInt(in[1]);

            a[v1].add(v2);
            a[v2].add(v1);
        }


        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            distance = new int[N + 1];
            bfs(i);

            print(distance);
            int sum = Arrays.stream(distance).sum();

            if (sum < min) {
                min = sum;
                result = i;
            }
        }
        System.out.println(result);
    }

    private static void print(int[] arr) {
        for (int i = 1; i <= N; i++) System.out.print(arr[i] + " ");
        System.out.println("\n");
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
                    visit[v] = true;
                    distance[v] = distance[cur] + 1;
                    q.add(v);
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}