package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/30
 * 촌수 계산 Review.
 */
public class BOJ2644RE {
    private static int N, M;
    private static ArrayList<Integer>[] a;
    private static boolean[] visit;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int start = toInt(in[0]), end = toInt(in[1]);
        M = toInt(br.readLine());

        a = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) a[i] = new ArrayList<>();

        // 인접 리스트를 이용하여 사람들간의 관계를 나타낸다.
        while (M-- > 0) {
            in = br.readLine().split(" ");
            int v1 = toInt(in[0]), v2 = toInt(in[1]);

            a[v1].add(v2);
            a[v2].add(v1);
        }

        bfs(start);
        if (distance[end] == 0) System.out.println(-1);
        else System.out.println(distance[end]);
    }

    // bfs 탐색을 이용하여 다른 사람과의 관계가 몇 단계를 거쳐야 하는지
    // distance 배열에 저장하여 나타낸다.
    private static void bfs(int v) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;
        distance[v] = 0;

        while (!q.isEmpty()) {
            int cur = q.remove();

            for (int vv : a[cur]) {
                if (!visit[vv]) {
                    visit[vv] = true;
                    q.add(vv);
                    distance[vv] = distance[cur] + 1;
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
