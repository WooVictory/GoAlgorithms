package programmers;

/**
 * created by victory_woo on 2020/08/09
 */
public class PGM17681 {
    public static void main(String[] args) {
        solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer1 = convert(n, arr1);
        String[] answer2 = convert(n, arr2);

        String[] result = new String[n];
        StringBuilder sb;
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < answer1[i].length(); j++) {
                if (isWall(answer1[i].charAt(j)) || isWall(answer2[i].charAt(j))) sb.append("#");
                if (isBlank(answer1[i].charAt(j)) && isBlank(answer2[i].charAt(j))) sb.append(" ");
            }
            result[i] = sb.toString();
        }

        for (int i = 0; i < n; i++) System.out.println(result[i]);

        return result;
    }

    private static String[] convert(int n, int[] arr) {
        String[] answer = new String[n];
        for (int i = 0; i < arr.length; i++) {
            StringBuilder result = new StringBuilder(Integer.toBinaryString(arr[i]));
            while (result.length() < n) result.insert(0, "0");

            answer[i] = result.toString();
        }
        return answer;
    }

    private static boolean isWall(char c) {
        return c == '1';
    }

    private static boolean isBlank(char c) {
        return c == '0';
    }
}
