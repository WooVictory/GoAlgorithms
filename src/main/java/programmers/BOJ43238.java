package programmers;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/08/29
 */
public class BOJ43238 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1;
        long right = n * times[times.length - 1];
        long sum;

        while (left <= right) {
            long mid = (left + right) / 2;
            sum = 0;

            for (int time : times) sum += mid / time;

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}