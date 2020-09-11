package blind18;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/09/11
 * 다트 게임.
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T")); // 37
        System.out.println(solution("1D2S0T")); // 3
        System.out.println(solution("1S*2T*3S")); // 23
        System.out.println(solution("1D#2S*3S")); // 5
        System.out.println(solution("1T2D3D#")); // -4
        System.out.println(solution("1D2S3T*")); // 59
        System.out.println(solution("1D2S#10S")); // 9
    }

    private static int solution(String dartResult) {
        int[] result = new int[3];
        int number = 0;
        int index = 0;
        int cache = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char value = dartResult.charAt(i);

            // S,D,T에 대한 연산이다.
            // 보너스는 필수이기 때문에 여기서 cache 초기화 작업이 이루어져야 한다.
            switch (value) {
                case 'S':
                    result[index++] = (int) Math.pow(number, 1);
                    cache = 0;
                    break;
                case 'D':
                    result[index++] = (int) Math.pow(number, 2);
                    cache = 0;
                    break;
                case 'T':
                    result[index++] = (int) Math.pow(number, 3);
                    cache = 0;
                    break;
                case '*':
                    // 이 경우에는 점수가 하나인 경우 스타상이 나온 상황이다.
                    // 따라서 하나의 점수만 스타상을 적용한다.
                    if (index == 1) {
                        result[index - 1] = result[index - 1] * 2;
                    } else {
                        // 2, 3의 경우이다.
                        // 따라서 자기 자신과 그 앞의 원소까지 스타상을 적용한다.
                        index--;
                        result[index] = result[index] * 2;
                        result[index - 1] = result[index - 1] * 2;
                        index++;
                    }
                    break;
                case '#':
                    // 아차상이며, 자기 자신만 아차상을 적용한다.
                    result[index - 1] = -result[index - 1];
                    break;
                default:
                    // 숫자가 나오는 경우, number 변수에 저장한다.
                    // 1이 나오는 경우, 10일 가능성을 확인해야 하기 때문에
                    // cache = 1을 저장하고 다음 number 가 0인지 확인한 뒤, 10을 넣어준다.
                    number = value - '0';
                    if (number == 1) {
                        cache = number;
                        continue;
                    }

                    // 10인 경우에 대해 처리한다.
                    if (cache == 1 && number == 0) {
                        number = 10;
                        cache = 0;
                    }
                    break;
            }
        }

        // result 합계를 반환한다.
        return Arrays.stream(result).sum();
    }
}
