package readyForKB.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * created by victory_woo on 2020/11/09
 */
public class Test1 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        solution(array, commands);
    }

    /*
    * 접근 방법.
    * i~j 까지의 배열 원소를 가지고 sub 리스트를 만든다.
    * 정렬한 뒤, k번째 원소를 result 에 추가해주면 된다.
    * */
    public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] command : commands) {

            ArrayList<Integer> sub = new ArrayList<>();
            for (int i = command[0] - 1; i <= command[1] - 1; i++) sub.add(array[i]);

            Collections.sort(sub);
            result.add(sub.size() == 1 ? sub.get(0) : sub.get(command[2] - 1));

        }

        return result.stream().mapToInt(x->x).toArray();
    }
}
