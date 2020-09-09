package sh_card;

import java.util.Stack;

/**
 * created by victory_woo on 2020/09/09
 * 1번 문제.
 * Stack 사용.
 */
public class Test1 {
    public static void main(String[] args) {
        solution(new int[]{500, 1000, -300, 200, -400, 100, -100});
        // expected : [500,500]
        // actual : [500,500]
        solution(new int[]{500, 1000, 2000, -1000, -1500, 500});
        // expected : [500,500,500]
        // actual : [500,500,500]
    }

    private static void solution(int[] deposit) {
        Stack<Integer> stack = new Stack<>();
        for (int money : deposit) {
            if (!stack.isEmpty() && money < 0) {
                int value;

                while (money < 0) {
                    value = stack.pop();
                    money = money + value;
                }

                if (money != 0) stack.push(money);

            } else {
                stack.push(money);
            }
        }

        System.out.println(stack);
    }
}
