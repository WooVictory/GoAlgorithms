package programmers;

/**
 * created by victory_woo on 2020/08/17
 */
public class PGM12911 {
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        String s = Integer.toBinaryString(n);
        int result = 0;
        for (int i = n + 1; i <= 1000000; i++) {
            String value = Integer.toBinaryString(i);
            if (isSameOneCount(s, value)) {
                result = i;
                break;
            }
        }

        return result;
    }

    private static boolean isSameOneCount(String s, String value) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
        }

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '1') count--;
        }

        return count == 0;
    }
}
