package blind18;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/09/10
 * 비밀지도.
 */
public class Test1 {
    public static void main(String[] args) {
        solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10});
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> list1 = getBinaryMap(arr1, n);
        ArrayList<String> list2 = getBinaryMap(arr2, n);
        String[] result = new String[n];

        // list1, list2 이진수 형태를 담고 있다.
        // 각 원소의 문자에 접근하여 둘 중 하나라도 1이면 벽을 표시하고
        // 아니라면 빈 공간을 표시한다.
        // StringBuilder 객체를 사용하며, 결과를 result 배열에 추가한다.
        for (int i = 0; i < n; i++) {
            String a = list1.get(i);
            String b = list2.get(i);
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (a.charAt(j) == '1' || b.charAt(j) == '1') sb.append('#');
                else sb.append(' ');
            }

            result[i] = sb.toString();
            System.out.println(result[i]);
        }
        System.out.println();

        return result;
    }

    // 배열의 각 요소를 이진수로 만든다.
    // 이진수의 길이가 n보다 작을 경우, n의 크기가 될때까지 앞에 0을 추가한다.
    private static ArrayList<String> getBinaryMap(int[] arr, int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int a : arr) {
            String binary = Integer.toBinaryString(a);
            StringBuilder sb = new StringBuilder(binary);

            while (sb.length() < n) sb.insert(0, 0);

            list.add(sb.toString());
        }
        return list;
    }
}
