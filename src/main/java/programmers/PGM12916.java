package programmers;

/**
 * created by victory_woo on 2020/08/05
 */
public class PGM12916 {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    public static boolean solution(String s) {
        s = s.toLowerCase();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') count++;
            if (s.charAt(i) == 'y') count--;
        }

        return count == 0;
    }
}