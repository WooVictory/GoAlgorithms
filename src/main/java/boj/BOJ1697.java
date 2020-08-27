package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/27
 */
public class BOJ1697 {
    private static final int MAX = 200000;
    private static boolean[] visit;
    private static int[] distance;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = toInt(in[0]);
        int k = toInt(in[1]);

        visit = new boolean[MAX + 1];
        distance = new int[MAX + 1];

        bfs();
        // 수빈이의 위치에 가는데 얼마나 걸리는지 확인한다.
        System.out.println(distance[k]);
    }

    // 수빈이가 걷거나 순간이동할 수 있는 경우.
    private static int[] moves = {1, -1, 2};

    private static void bfs() {
        // 큐에 수빈이의 최초 위치를 넣는다.
        LinkedList<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        distance[n] = 0;

        // 큐에서 뺀다.
        while (!q.isEmpty()) {
            // 수빈이의 위치를 큐에서 뺀다.
            int cur = q.remove();

            // 수빈이가 이동할 수 있는 방법은 3가지 이다.
            // 앞으로 가기, 뒤로 가기, 순간이동 - 모두 1초 걸린다.
            for (int i = 0; i < moves.length; i++) {
                int next;
                if (i == 2) next = cur * moves[i];
                else next = cur + moves[i];
                // 수빈이가 이동할 다음 위치를 구한다.


                // 범위를 벗어나는지 확인한다.
                if (next < 0 || next >= MAX) continue;

                // 방문한 적이 없다면, 방문 여부를 체크하고 큐에 넣는다.
                // 그리고 다음 정점까지 오는데 현재 정점까지 오는데 걸리는 시간 + 1초를 하여 저장한다.
                if (!visit[next]) {
                    distance[next] = distance[cur] + 1;
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
