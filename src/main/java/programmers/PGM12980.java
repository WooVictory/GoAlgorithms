package programmers;

/**
 * created by victory_woo on 2020/08/20
 */
public class PGM12980 {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        int answer = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n--;
                answer++;
            }
        }
        return answer;
    }
}
