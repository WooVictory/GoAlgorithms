package readyForKB.StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/11/06
 */
public class Test2 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        solution(progresses, speeds);

        solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }

    /*
     * 접근 방법.
     * 100 - progresses[i]를 통해 남은 작업량을 구할 수 있다.
     * 남은 작업량과 speeds[i]를 이용하여 기능을 배포하기 위해 몇일이 걸리는지 구할 수 있다.
     * 이를 q에 담아서 관리한다. 다음에 구한 일수가 q에 있는 일자보다 짧게 걸린다면, 가장 긴 일수에 함께 배포가 되어야 하기 때문에
     * 큐에 담아서 관리한다. 만약, 큐에 담겨있는 일수보다 큰 일수가 걸리는 기능이 들어온다면 result 에 함께 배포 되어야 하는 기능의 갯수를 담고
     * 큐를 비운 뒤, 큐에 day 를 다시 담아서 위의 과정을 반복한다.
     *
     * 마지막으로 큐에 들어있는 day 가 처리되지 않을 수 있기 때문에 확인하고 마지막까지 담아준다.
     * */
    public static int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        LinkedList<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int speed = speeds[i];
            int remain = 100 - progresses[i];
            int day;

            if (remain % speed == 0) day = remain / speed;
            else day = remain / speed + 1;

            if (q.isEmpty() || day <= q.getFirst()) {
                q.add(day);
            } else {
                result.add(q.size());
                q.clear();
                q.add(day);
            }
        }

        if (!q.isEmpty()) result.add(q.size());

        return result.stream().mapToInt(x -> x).toArray();
    }
}
