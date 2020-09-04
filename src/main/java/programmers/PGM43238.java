package programmers;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/09/04
 */
public class PGM43238 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 1;
        long end = n * times[times.length - 1];

        while (start < end) {
            long mid = (start + end) / 2;
            long total = 0;

            for (int time : times) total += (mid / time);

            if (total < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }

        }

        return answer;
    }
}
