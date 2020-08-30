package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/30
 * MAX = 10만으로 설정시, 런타임 에러 발생
 * 이유는 수빈이가 99999에서 순간이동 하면 18만 언저리로 가기 때문..!
 */
public class BOJ1697RE {

    private static final int MAX = 200000;
    private static boolean[] visit;
    private static int[] distance;
    private static int[] method = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = toInt(in[0]), K = toInt(in[1]);

        visit = new boolean[MAX + 1];
        distance = new int[MAX + 1];
        bfs(N);

        System.out.println(distance[K]);
    }

    private static void bfs(int N) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(N);
        visit[N] = true;
        distance[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.remove();
            int next;


            for (int i = 0; i < 3; i++) {
                if (i == 2) next = cur * method[i];
                else next = cur + method[i];

                if (next < 0 || next >= MAX) continue;
                if (visit[next]) continue;

                q.add(next);
                visit[next] = true;
                distance[next] = distance[cur] + 1;
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}