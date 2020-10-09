package week5.RomanToInteger;

import java.util.HashMap;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo2 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("MDCXCV"));
    }

    /*
    * 2개씩 차례대로 비교해나간다.
    * 하나씩 다음 단계에서 비교한다.
    * prev < cur -> 누적합 sum 에서 prev 를 빼준다.
    * prev >= cur -> 누적합 sum 에 prev 를 더해준다.
    *
    * 반복문을 다 돌고 나오면 마지막 원소는 누적되지 않으므로 sum += prev.
    * */
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int prev = map.get(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));

            if (prev < cur) sum -= prev;
            else sum += prev;

            prev = cur;
        }

        sum += prev;
        return sum;
    }
}
