package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/09/12
 * 투포인터 - 수들의 합2
 */
public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = toInt(in[0]);
        long m = Long.parseLong(in[1]);

        int[] a = new int[n];
        in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = toInt(in[i]);
        }

        int start = 0, end = 0;
        long sum = 0;
        int count = 0;

        while (true) {
            // 부분합이 m보다 크거나 같은 경우, start 를 sum 에서 빼고
            // start 포인터는 한칸 뒤로 이동한다.
            if (m <= sum) {
                sum = sum - a[start];
                start++;
            } else if (end == n) {
                // end 가 끝에 도달하면 반복문을 빠져나온다.
                break;
            } else {
                // 위의 조건들을 만족하지 못한 경우
                // sum 에 end 위치의 값을 더하고
                // end 포인터는 한칸 뒤로 이동한다.
                sum = sum + a[end];
                end++;
            }

            // 부분합이 m과 같다면 경우의 수를 증가시킨다.
            if (sum == m) count++;
        }

        System.out.println(count);
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}