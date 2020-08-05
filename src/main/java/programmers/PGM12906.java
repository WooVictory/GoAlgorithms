package programmers;

import java.util.Stack;

/**
 * created by victory_woo on 2020/08/05
 * 같은 숫자는 싫어.
 */
public class PGM12906 {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        solution(new int[]{4, 4, 4, 3, 3});
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) stack.push(arr[i]);
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) result[i] = stack.pop();

        return result;
    }
}
