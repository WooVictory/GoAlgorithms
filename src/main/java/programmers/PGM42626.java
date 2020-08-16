package programmers;

import java.util.PriorityQueue;

/**
 * created by victory_woo on 2020/08/16
 */
public class PGM42626 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int value : scoville) pq.add(value);

        int answer = 0;
        while (!check(pq, k)) {
            if (pq.size() == 1) return -1;

            int first = pq.remove();
            int second = pq.remove();

            pq.add(first + (second * 2));
            answer++;
        }

        return answer;
    }

    private static boolean check(PriorityQueue<Integer> pq, int k) {
        for (Integer value : pq) {
            if (value < k) return false;
        }
        return true;
    }
}
