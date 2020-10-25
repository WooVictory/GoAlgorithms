package programmers;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/10/23
 */
public class PGM49189 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        }));
    }


    private static ArrayList<Integer>[] a;
    private static boolean[] visit;
    private static int[] distance;
    private static int max = Integer.MIN_VALUE;

    public static int solution(int n, int[][] edge) {
        a = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) a[i] = new ArrayList<>();

        for (int[] vertex : edge) {
            int v1 = vertex[0], v2 = vertex[1];

            a[v1].add(v2);
            a[v2].add(v1);
        }

        bfs();

        int answer = 0;

        for (int d : distance) if (max == d) answer++;

        return answer;
    }

    static void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        distance[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int v : a[cur]) {
                if (!visit[v]) {
                    visit[v] = true;
                    q.add(v);
                    distance[v] = distance[cur] + 1;
                    max = Math.max(max, distance[v]);
                }
            }
        }
    }
}
