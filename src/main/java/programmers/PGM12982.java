package programmers;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/08/10
 */
public class PGM12982 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 4, 5}, 9));
        System.out.println(solution(new int[]{2, 2, 3, 3}, 10));
    }

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int total = 0;
        int count = 0;
        for (int department : d) {
            total += department;
            if (total <= budget) count++;
        }

        return count;
    }
}
