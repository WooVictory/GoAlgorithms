package blind20;

/**
 * created by victory_woo on 2020/09/11
 * 문자열 압축.
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    private static int solution(String s) {
        int len = s.length();
        int min = len;

        StringBuilder sb;
        // 문자열을 앞에서부터 정해진 길이만큼 잘라야 하기 때문에
        // 문자열 길이의 절반까지만 자른다.
        // 아래는 몇개로 자를건지를 정한다.
        for (int i = 1; i <= len / 2; i++) {
            String now;
            String next = "";
            int count = 1;

            sb = new StringBuilder();
            // 몇개로 자르는지에 따라 문자열 s가 몇 등분으로 나뉘는지 나온다.
            for (int j = 0; j <= len / i; j++) {
                int start = i * j; // 자를 시작 위치를 찾는다.
                int end = i * (j + 1); // 자를 끝 위치를 찾는다.
                if (end > len) end = len; // end 값이 len 보다 커지더라도 최대 len 까지이다.

                // now 를 초기화 하고
                // next 에 자른 값을 넣는다.
                now = next;
                next = s.substring(start, end);

                // 동일하다면 카운트 하고 반복한다.
                if (now.equals(next)) {
                    count++;
                } else {
                    // 다르다면 카운트를 붙이고 now 문자열을 붙여준다.
                    // 카운트는 1로 초기화한다.
                    sb.append(getCount(count)).append(now);
                    count = 1;
                }
            }

            // next 가 붙여지지 않았기 때문에 마지막에 붙여준다.
            sb.append(getCount(count)).append(next);
            String result = sb.toString();
            // 압축된 문자열의 길이를 비교하여 가장 짧은 경우의 길이를 min 값에 갱신한다.
            if (result.length() < min) min = result.length();
        }

        return min;
    }

    // count 가 1보다 작거나 같을 경우, 숫자 생략.
    private static String getCount(int count) {
        return count > 1 ? count + "" : "";
    }
}
