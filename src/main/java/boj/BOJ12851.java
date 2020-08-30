package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/30
 */
public class BOJ12851 {
    private static final int MAX = 200000;
    private static int N, K;
    private static int[] times;
    private static int[] ways;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = toInt(in[0]);
        K = toInt(in[1]);

        visit = new boolean[MAX + 1];
        times = new int[MAX + 1];
        ways = new int[MAX + 1];
        bfs();
        System.out.println(times[K]);
        System.out.println(ways[K]);
    }

    private static void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(N);
        visit[N] = true;
        times[N] = 0;
        ways[N] = 1;


        while (!q.isEmpty()) {
            int now = q.remove();
            int next;

            for (int i = 0; i < 3; i++) {
                if (i == 2) next = now * move_state[i];
                else next = now + move_state[i];

                if (next < 0 || next >= MAX) continue;

                // 방문 여부를 체크하기 전에, 최소 시간인지를 먼저 확인한다.
                // now 에서 next 로 갈 수 있는 시간이 이미 존재한다면
                // now -> next 로 갈 수 있는 최소 시간이 여러 번 존재할 수 있다는 뜻이다.
                // 따라서 next 를 만들 수 있는 경우의 수를 추가하여준다.
                if (times[next] == times[now] + 1) ways[next] += ways[now];

                // 방문한 적이 없다면 방문 여부를 체크하고 큐에 넣어준다.
                // next 를 만드는 데 걸리는 시간은 now + 1 만큼이다.
                // next 를 만들 수 있는 경우의 수는 next 만드는 경우의 수 + now 만드는 경우의 수이다.
                // ways[4] = 0, ways[2] = 2
                // ways[4] = ways[4]+ways[2] = 2가 되는 것이다.
                // 따라서 4를 만들 수 있는 경우의 수는 2가지가 된다.
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    times[next] = times[now] + 1;
                    ways[next] += ways[now];
                }
            }
        }

    }


    private static int[] move_state = {1, -1, 2};
    private static int minTime = Integer.MAX_VALUE;
    private static int count = 0;

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
