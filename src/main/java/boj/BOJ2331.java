package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * created by victory_woo on 2020/08/26
 * HashMap 풀이.
 */
public class BOJ2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int a = toInt(in[0]);
        int p = toInt(in[1]);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(a, 0);
        int count = 1;
        int current = a;
        int num;

        while (true) {
            num = 0;
            int r;
            while (current != 0) {
                r = current % 10;
                current /= 10;
                num += Math.pow(r, p);
            }

            //System.out.println(num);
            if (map.containsKey(num)) {
                System.out.println(map.get(num));
                return;
            }

            map.put(num, count++);
            current = num;
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
