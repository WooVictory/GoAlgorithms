package programmers;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/10/24
 */
public class PGM12936 {
    public static void main(String[] args) {
        solution(3, 5);
        solution(4, 9);
    }

    public static int[] solution(int n, long k) {
        ArrayList<Integer> people = new ArrayList<>();
        int[] answer = new int[n];
        int fac = 1;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            people.add(i);
            fac = fac * i;
        }

        k--;

        while (n > 0) {
            fac = fac / n;
            n--;

            answer[index] = people.get((int) (k / fac));
            people.remove((int) (k / fac));

            k = k % fac;
            index++;
        }

        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }

    /*private static LinkedList<Integer> list;
    private static boolean[] visit;
    private static HashMap<Long, ArrayList<Integer>> map;
    private static long count = 1;

    public static int[] solution(int n, long k) {
        list = new LinkedList<>();
        visit = new boolean[n + 1];
        map = new HashMap<>();


        permutation(n, n);

        ArrayList<Integer> ways = map.get(k);
        int[] answer = new int[ways.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = ways.get(i);
        return answer;
    }

    private static void permutation(int n, int r) {
        if (list.size() == r) {
            check();
            return;
        }


        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(i);
                permutation(n, r);

                visit[i] = false;
                list.removeLast();
            }
        }
    }

    private static void check() {
        ArrayList<Integer> result = new ArrayList<>(list);

        map.put(count++, result);
    }*/
}
