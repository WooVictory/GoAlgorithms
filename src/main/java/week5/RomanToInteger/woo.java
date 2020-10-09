package week5.RomanToInteger;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("MDCXCV"));
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        ArrayList<Integer> list = new ArrayList<>();
        for (String word : s.split("")) {
            list.add(map.get(word));
        }

        System.out.println(list);
        int i = 0;
        int sum = 0;
        int a = 0, b = 0;
        boolean flag = false;
        while (i < list.size() - 1) {
            a = list.get(i);
            b = list.get(i + 1);

            if (a < b) {
                flag = false;
                sum += (b - a);
                i += 2;
            } else {
                flag = true;
                sum += a;
                i++;
            }
        }

        if (flag) sum += b;

        return sum;
    }
}
