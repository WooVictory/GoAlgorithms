package programmers;

/**
 * created by victory_woo on 2020/09/04
 */
public class PGM12904RE {
    public static void main(String[] args) {
        System.out.println(solution("abcdcba"));
        System.out.println(solution("abacde"));
        System.out.println(solution("aaa"));
    }

    public static int solution(String s) {
        for (int i = s.length(); i > 0; i--) {
            int start = 0;
            int end = i - 1;

            while (end < s.length()) {
                if (isPalindrome(s, start, end)) {
                    return i;
                }
                start++;
                end++;
            }
        }
        return 1;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        int mid = (end - start + 1) / 2;
        for (int i = 0; i < mid; i++) {
            char a = s.charAt(start + i);
            char b = s.charAt(end - i);

            if (a != b) return false;
        }
        return true;
    }
}
