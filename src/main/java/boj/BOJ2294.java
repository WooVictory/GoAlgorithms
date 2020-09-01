package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/09/01
 */
public class BOJ2294 {
    private static final int MAX = 100000;
    private static int n, k;
    private static int[] a;
    private static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = toInt(in[0]);
        k = toInt(in[1]);

        a = new int[n + 1];
        d = new int[MAX + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = toInt(br.readLine());
        }

        for (int i = 1; i <= k; i++) d[i] = MAX + 1;
        d[0] = 0;


        for (int i = 1; i <= n; i++) {
            int coin = a[i];
            for (int j = coin; j <= k; j++) {
                d[j] = Math.min(d[j], d[j - coin] + 1);
            }
        }

        if (d[k] == MAX + 1) d[k] = -1;

        System.out.println(d[k]);
    }


    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
