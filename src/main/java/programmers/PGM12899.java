package programmers;

/**
 * created by victory_woo on 2020/08/14
 */
public class PGM12899 {
    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(9));
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {

            int mod = n % 3; // 나머지.
            n = n / 3; // 몫.

            if (mod == 0) {
                mod = 4;
                n = n - 1;
                // 나누어 떨어지는 경우, 몫이 1 크기 때문에 줄여준다.
            }
            sb.insert(0, mod);
        }
        return sb.toString();
    }
}
