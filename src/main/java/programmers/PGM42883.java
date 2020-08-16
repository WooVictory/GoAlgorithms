package programmers;

import java.util.Stack;

/**
 * created by victory_woo on 2020/08/16
 */
public class PGM42883 {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }


    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }
}
