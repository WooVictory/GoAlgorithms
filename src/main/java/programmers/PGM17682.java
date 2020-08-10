package programmers;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/08/10
 */
public class PGM17682 {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }

    public static int solution(String dartResult) {
        int[] result = new int[3];
        int index = 0;
        int cache = 0;
        int number = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)) {
                number = c - '0';
                if (number == 1) cache = 1;

                if (cache == 1 && number == 0) number = 10;

            } else if (isBonus(c)) {
                result[index++] = pow(c, number);
                cache = 0;
            } else if (isOption(c)) {
                applyOption(c, index, result);
            }
        }

        return Arrays.stream(result).sum();
    }

    private static int pow(char c, int number) {
        switch (c) {
            case 'S':
                return (int) Math.pow(number, 1);
            case 'D':
                return (int) Math.pow(number, 2);
            default:
                return (int) Math.pow(number, 3);
        }
    }

    private static boolean isBonus(char c) {
        return c == 'S' || c == 'D' || c == 'T';
    }

    private static boolean isOption(char c) {
        return c == '*' || c == '#';
    }

    private static void applyOption(char c, int index, int[] result) {
        int tempIndex;
        switch (c) {
            case '*': // 스타상.
                tempIndex = index - 1;
                if (tempIndex > 0) {
                    result[tempIndex] *= 2;
                    result[tempIndex - 1] *= 2;
                } else {
                    result[tempIndex] *= 2;
                }
                break;
            case '#': // 아차상.
                tempIndex = index - 1;
                result[tempIndex] = -result[tempIndex];
                break;
        }
    }
}
