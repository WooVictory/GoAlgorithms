package blind20;

/**
 * created by victory_woo on 2020/09/11
 * 괄호 변환.
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        // expected : (()())()
        // actual   : (()())()

        System.out.println(solution("()))((()"));
        // expected : ()(())()
        // actual   : ()(())()

        System.out.println(solution(")("));
        // expected : ()
        // actual   : ()
    }

    private static String solution(String p) {
        return solve(p);
    }

    private static String solve(String p) {
        // 1. 빈 문자열이라면 빈 문자열을 반환한다.
        if (p.length() == 0) return "";

        // 2. p를 두 균형잡힌 괄호 문자열로 분리한다.
        // u는 균형잡힌 괄호 문자열로 더이상 분리할 수 없을만큼 작아야 한다.
        int index = split(p);

        // index 가 -1이라면 빈 문자열을 반환한다.
        if (index == -1) return "";

        // u와 v로 분리한다.
        String u = p.substring(0, index);
        String v = p.substring(index);

        // 3. u가 올바른 괄호 문자열인지 판별한다. 올바른 괄호 문자열이라면
        // v에 대해 1단계부터 다시 수행하며 u 뒤에 그 결과를 붙여 반환한다.
        if (isRightBracket(u)) {
            return u + solve(v);
        } else {
            // 4. u가 올바른 괄호 문자열이 아닌 경우.
            // v에 대해 1단계부터 수행한 결과의 앞에 '('를 붙이고 뒤에 ')'를 붙인 값을 만든다.
            // u의 첫번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호방향을 뒤집는다.
            // '(' -> ')'이 되고 ')' -> '('이 된다.
            // result 뒤에 u를 붙여 반환한다.
            String result = '(' + solve(v) + ')';
            u = u.substring(1, u.length() - 1);
            u = reverse(u);
            return result + u;
        }
    }

    // 괄호의 방향을 뒤집은 결과를 반환한다.
    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }

    // 올바른 괄호 문자열인지 확인한다.
    private static boolean isRightBracket(String u) {
        int count = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') count++;
            else count--;

            if (count < 0) return false;
        }
        return count == 0;
    }

    // 균형잡힌 문자열로 분리할 수 있는 가장 작은 인덱스를 찾아 반환하며,
    // 없다면 -1을 반환한다.
    private static int split(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count++;
            else count--;

            if (count == 0) return i + 1;
        }
        return -1;
    }
}