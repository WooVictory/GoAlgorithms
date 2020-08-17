package programmers;

/**
 * created by victory_woo on 2020/08/17
 */
public class PGM12909 {
    public static void main(String[] args) {
        System.out.println((solution("()()")));
        System.out.println((solution("(())()")));
        System.out.println((solution(")()(")));
        System.out.println(solution("(()("));
    }

    public static boolean solution(String s) {
        if (s.length() % 2 != 0) return false;

        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;

            if (count < 0) return false;
        }
        return count == 0;
    }
}
