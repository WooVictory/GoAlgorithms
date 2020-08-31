package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/31
 * 숨바꼭질3
 */
public class BOJ13549 {
    private static final int MAX = 200000;
    private static int n, k;
    private static int[] times;
    private static boolean[] visit;
    private static int[] move_state = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = toInt(in[0]);
        k = toInt(in[1]);

        times = new int[MAX + 1];
        visit = new boolean[MAX + 1];

        bfs();
        System.out.println(times[k]);
    }

    private static void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        times[n] = 0;

        while (!q.isEmpty()) {
            // 수빈이의 현재 위치를 큐에서 뺀다.
            int now = q.remove();

            // 현재 위치에서 *2 하여 순간이동으로 갈 수 있는 곳을 먼저 계산한다.
            int teleportation = now * 2;

            // 최대값인 MAX 까지 계산하며 방문하지 않은 곳이어야 한다.
            // 방문 여부를 체크하고 큐에 넣어준다.
            // 또한, 순간이동은 0초가 걸리기 때문에 이전 위치의 시간과 동일하다.
            while (teleportation <= MAX && !visit[teleportation]) {
                visit[teleportation] = true;
                q.add(teleportation);
                times[teleportation] = times[now];
                teleportation = teleportation * 2;
            }

            // 순간이동을 먼저 계산했기 때문에 이번에는 걷기 이동에 대해 계산한다.
            for (int i = 0; i < 2; i++) {
                int next = now + move_state[i];

                if (next < 0 || next >= MAX) continue;

                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    times[next] = times[now] + 1; // 걷기는 1초 걸리기 때문에 1초의 시간이 걸리는 것을 더해준다.
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}