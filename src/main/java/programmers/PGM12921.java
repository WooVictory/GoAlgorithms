package programmers;

/**
 * created by victory_woo on 2020/08/06
 * 소수 구하기. 에라토스테네스의 체.
 */
public class PGM12921 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        boolean[] check = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (check[i]) continue;

            for (int j = i + i; j <= n; j += i) {
                check[j] = true;
            }
        }

        int count=0;
        for (int i=2;i<=n;i++){
            if (!check[i]) count++;
        }

        return count;
    }
}
