package programmers;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/10/23
 */
public class PGM12907 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1, 2, 5}));
    }

    public static int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        Arrays.sort(money);
        dp[0] = 1;

        for (int i = 0; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] = dp[j] + dp[j - money[i]];
            }
        }

        return dp[n] % 1000000007;
    }
}
