package 베이글;

import java.util.Arrays;
import java.util.HashMap;

/**
 * created by victory_woo on 2020/11/05
 */
public class Q3 {
    public static void main(String[] args) {
        System.out.println(solution(10, new int[]{1, 1, 2, 2, 2, 3, 3, 3, 2, 2}));
    }

    /*public static int solution(int n, int[] colors) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int color = colors[i];

            map.put(color, map.getOrDefault(color, 0) + 1);
        }

        System.out.println(map);

        int answer = 0;

        for (Integer value : map.values()) {
            answer += (int) Math.pow(value, 2);
        }

        return answer;
    }*/


    public static int solution(int n, int[] colors) {
        Arrays.sort(colors);

        int answer = 0;
        int cur = colors[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (cur == colors[i]) count++;
            else {
                System.out.println(count);
                answer = answer + (int) Math.pow(count, 2);
                count = 1;
            }

            cur = colors[i];
        }

        answer = answer + (int) Math.pow(count, 2);

        return answer;
    }
}
