package programmers;

/**
 * created by victory_woo on 2020/08/29
 */
public class BOJ12900 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    private static final int MOD = 1000000007;

    public static int solution(int n) {
        int a = 1;
        int b = 1;
        switch (n) {
            case 1:
            case 2:
                return 1;
            default:
                int c = a + b;
                for (int i = 3; i <= n + 1; i++) {
                    c = (a + b) % MOD;
                    a = b;
                    b = c;
                }

                return c;
        }
    }
}
