package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * created by victory_woo on 2020/08/18
 */
public class PGM12941 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static int solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : arr2) list.add(value);

        Arrays.sort(arr1);
        list.sort(Collections.reverseOrder());
        int result = 0;
        for (int i = 0; i < arr1.length; i++) result += (arr1[i] * list.get(i));

        return result;
    }
}