package programmers;

/**
 * created by victory_woo on 2020/10/24
 */
public class PGM12914 {
    public static void main(String[] args) {
        //System.out.println(solution(4));
        //System.out.println(solution(6));
        System.out.println(solution(1000));
        System.out.println(solution(2000));
    }

    /*
     * 첫 번째 접근 방법.
     * dp.
     * */
    public static long solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return (long) (dp[n]);
    }


    /*
     * 두 번째 접근 방법.
     * 재귀 호출을 이용했다.
     * n=1000이 되더라도 결과가 나오지 않는다. 재귀 호출이므로 스택이 넘쳐서 그런 것으로 확인된다.
     * */
    /*private static int[] way = {1, 2};
    private static long count = 0;

    public static long solution(int n) {

        dfs(0, n);

        return count % 1234567;
    }

    private static void dfs(int total, int n) {
        if (total == n) {
            count++;
            return;
        }

        for (int i = 0; i < way.length; i++) {
            if (total + way[i] <= n) dfs(total + way[i], n);
        }
    }*/


    /*
    * 세 번째 접근 방법.
    * 첫 번째 접근 방법와 유사.
    * 구할 때마다 1234567로 나눈 나머지를 구해준다.
    *
    * */
    /*public static long solution(int n) {
        long[] dp = new long[2001];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }*/
}
