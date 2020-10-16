package blind21;

/**
 * created by victory_woo on 2020/09/12
 */
public class Test1 {
    public static void main(String[] args) {
        //System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        // e : bat.y.abcdefghi
        // a : bat.y.abcdefghi

        //System.out.println(solution("z-+.^."));
        // e : z--
        // a : z--

        System.out.println(solution("=.="));
        System.out.println(solution("___"));
        System.out.println(solution("=.=."));
        System.out.println(solution("=.=.=.2"));
        System.out.println(solution(".a.a.33s.."));
    }

    // 이거 5개 틀림..
    public static String solution(String new_id) {
        // 1. 소문자로 치환.
        new_id = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (char ch : new_id.toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                sb.append(ch);
            }
        }

        // 2. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환.
        new_id = sb.toString();
        char now, next = ' ';
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            now = next;
            next = new_id.charAt(i);

            if (now != next) {
                result.append(now);
            }
        }

        result.append(next);
        // 공백이 존재하기 때문에 제거!
        new_id = result.toString().trim();

        // 4.
        // 처음에 마침표가 존재하면 제거.
        if (new_id.charAt(0) == '.') {
            if (new_id.length() == 1) new_id = " ";
            else new_id = new_id.substring(1);
        }

        // 마지막에 마침표가 존재하면 제거.
        if (new_id.charAt(new_id.length() - 1) == '.') {
            if (new_id.length() == 1) new_id = " ";
            else new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5. 빈 문자열이라면 "a" 대입.
        if (new_id.length()<=0) new_id = "a";

        if (16 <= new_id.length()) new_id = new_id.substring(0, 15);

        // 마지막에 마침표가 존재하면 제거.
        if (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);

        if (new_id.length() <= 2) {
            char last = new_id.charAt(new_id.length() - 1);

            sb = new StringBuilder(new_id);
            while (sb.length() < 3) {
                sb.append(last);
            }
            new_id = sb.toString();
        }

        return new_id;
    }

    // 이게 맞음.
    public static String solution2(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        if (new_id.length() <= 0) new_id = "a";

        if (16 <= new_id.length()) new_id = new_id.substring(0, 15);

        if (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);


        if (new_id.length() <= 2) {
            char last = new_id.charAt(new_id.length() - 1);

            StringBuilder sb = new StringBuilder(new_id);
            while (sb.length() < 3) {
                sb.append(last);
            }
            new_id = sb.toString();
        }
        return new_id;
    }
}
