package readyForKB.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/11/10
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }

    /*
     * 첫 번째 접근 방법.
     * 순열을 이용하여 접근했다.
     * 순열을 이용해서 가능한 모든 경우를 다 구하고 숫자로 바꿔서 최대값을 찾고
     * 최댓값을 문자열로 변환해서 반환한다.
     * 범위가 커질 것 같아서 long 으로 처리했는데, 예제 테케만 통과하고 나머지는 런타임 에러가 난다.
     * */
    /*private static LinkedList<Integer> list;
    private static boolean[] visited;
    private static long max;

    public static String solution(int[] numbers) {
        max = Integer.MIN_VALUE;
        list = new LinkedList<>();
        visited = new boolean[numbers.length];

        permutation(numbers.length, numbers.length, numbers);

        return String.valueOf(max);
    }

    private static void permutation(int n, int r, int[] numbers) {
        if (list.size() == r) {
            StringBuilder sb = new StringBuilder();
            for (int idx : list) sb.append(numbers[idx]);

            long value = Long.parseLong(sb.toString());
            if (max < value) max = value;

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                permutation(n, r, numbers);
                visited[i] = false;
                list.removeLast();
            }
        }
    }*/

    /*
    * 두 번째 접근 방법.
    * int[] -> String[] 변경.
    * String 2개를 이어붙인 문자열을 비교하여 내림차순 정렬을 한다.
    * 3, 32를 비교한다고 해보자.
    * [3,32] = 332 / [32,3] = 323
    * 332가 더 큰 값이 된다. 따라서 정렬이 되면 3, 32, ~~ 이렇게 정렬된다.
    * 배열에 있는 값을 모두 붙여서 문자열로 반환하면 원하는 정답을 구할 수 있다.
    *
    * 다만, [0,0,0,0, ...]처럼 구성되어 있는 배열이라면
    * 정렬을 하더라도 맨 앞에는 0이 위치하게 된다. 따라서 배열의 첫번째 원소가 0이라면 "0"을 반환한다.
    * */
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (arr[0].equals("0")) return "0";

        return String.join("", arr);
    }
}
