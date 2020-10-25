package nhn;

import java.util.Stack;

/**
 * created by victory_woo on 2020/10/24
 * 숫자가 없는 경우, 스택에서 다 빼는게 아니라 맨 앞에 것만 빼서 처리해야 됨...
 */
public class Test3 {
    public static void main(String[] args) {
//        solution(2, new String[]{"B2(RG)", "3(R2(GB))"});
        solution(3, new String[]{"3(BR2(R))", "B(RGB(RG))", "1B2R3G"});

        /*
         *
         * BRRRBRRRBRRR
         * BRBGBBBRBBBG
         * BRRGGG
         * */
    }

    private static void solution(int numOfOrder, String[] orderArr) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        /*for (int i = 0; i < numOfOrder; i++) {
            System.out.println(convert(orderArr[i]));
        }*/
        System.out.println(convert(orderArr[1]));
    }

    private static String convert(String order) {
        Stack<Integer> numStack = new Stack<>(); // 숫자 저장.
        Stack<Character> stack = new Stack<>(); // 괄호, 문자 저장.
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);

            if (Character.isDigit(c)) {
                numStack.push(c - '0');
            } else if (c == '(' || Character.isAlphabetic(c)) {
                stack.push(c);
            } else if (c == ')') {
                while (true) {
                    char top = stack.pop();
                    if (top == '(') break;

                    sb.append(top);
                }

                System.out.println("SB : " + sb.toString());

                if (!numStack.isEmpty()) {
                    int n = numStack.pop();
                    for (int j = 0; j < n; j++) {
                        result.append(sb.toString());
                    }
                } else {
                    // 숫자가 없는 경우가 나온다면.
                    result.append(sb.toString());
                }

                System.out.println("Result : " + result.toString());
                sb = new StringBuilder(result.toString());
                result = new StringBuilder();

            }
        }

        System.out.println(stack);
        System.out.println(numStack);


        // 빠지지 않은 문자들 처리하기 위함.
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        StringBuilder answer = new StringBuilder();
        int len = 0;
        while (!numStack.isEmpty()) {
            int top = numStack.pop();

            while (top-- > 0) answer.append(sb.charAt(len));

            len++;
        }


        if (answer.length() > 0) return answer.reverse().toString();

        return sb.reverse().toString();
    }
}
