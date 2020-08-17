package programmers;

/**
 * created by victory_woo on 2020/08/17
 */
public class PGM12924 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    private static int count = 0;

    public static int solution(int n) {
        int answer;
        for (int i = 1; i <= n; i++) {
            answer = i;
            for (int j = i + 1; j <= n; j++) {
                answer += j;
                if (answer >= n) {
                    if (answer == n) count++;

                    break;
                }
            }
        }

        return count + 1;
    }

}
