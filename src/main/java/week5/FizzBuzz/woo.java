package week5.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    // 가장 간단한 방법.
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
