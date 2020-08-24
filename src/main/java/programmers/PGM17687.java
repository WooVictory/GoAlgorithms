package programmers;

/**
 * created by victory_woo on 2020/08/24
 */
public class PGM17687 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        // expected : 02468ACE11111111
        // actual :   02468ACE11111111
        System.out.println(solution(16, 16, 2, 2));
    }

    // n 진수, t개를 먼저 구한다.
    // m명의 인원이 있고, 튜브의 순서는 p이다.
    public static String solution(int n, int t, int m, int p) {
        String[] alphabets = {"A", "B", "C", "D", "E", "F"};
        StringBuilder binarys = new StringBuilder("0");
        int num = 1;

        while (binarys.length() - 1 < t * m) {
            int quot = num;
            int remain;
            StringBuilder subBinarys = new StringBuilder();

            while (quot > 0) {
                remain = quot % n;
                quot = quot / n;

                if (10 <= remain && remain <= 15) subBinarys.append(alphabets[remain - 10]);
                else subBinarys.append(remain);
            }

            binarys.append(subBinarys.reverse());
            num++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            answer.append(binarys.charAt(p - 1));
            p += m;
        }

        return answer.toString();
    }
}
