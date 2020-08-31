package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/31
 * times : 동생을 찾는데 걸리는 최소 시간을 저장.
 * ways : 동생을 최소 시간으로 찾는데 존재하는 방법의 수를 저장.
 */
public class BOJ12581RE {
    private static final int MAX = 200000;
    private static int n, k;
    private static boolean[] visit;
    private static int[] times, ways;
    private static int[] move_state = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = toInt(in[0]);
        k = toInt(in[1]);

        visit = new boolean[MAX + 1];
        times = new int[MAX + 1];
        ways = new int[MAX + 1];

        bfs();

        System.out.println(times[k]);
        System.out.println(ways[k]);
    }

    private static void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(n);
        times[n] = 0;
        ways[n] = 1;
        visit[n] = true;

        while (!q.isEmpty()) {
            int now = q.remove();
            int next;

            for (int i = 0; i < 3; i++) {
                if (i == 2) next = now * move_state[i];
                else next = now + move_state[i];

                if (next < 0 || next >= MAX) continue;

                // 이미 방문한 적이 있지만(즉, 최소 시간이 존재한다는 뜻), 최소 시간으로 또 방문한 경우에 조건문을 탈 수 있다.
                // 중복 방문을 허용하여 방법의 수를 증가하게 된다.
                // 단, 최소 시간을 갈 수 있는 방법이어야 한다.
                if (times[next] == times[now] + 1) ways[next] += ways[now];

                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    times[next] = times[now] + 1;
                    ways[next] += ways[now];
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}