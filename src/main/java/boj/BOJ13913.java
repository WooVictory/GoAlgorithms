package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

/**
 * created by victory_woo on 2020/08/31
 */
public class BOJ13913 {
    private static final int MAX = 200000;
    private static int n, k;
    private static int[] times;
    private static int[] from;
    private static boolean[] visit;
    private static int[] move_state = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = toInt(in[0]);
        k = toInt(in[1]);

        times = new int[MAX + 1];
        visit = new boolean[MAX + 1];
        from = new int[MAX + 1];

        bfs();
    }

    private static void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        from[n] = 0;
        times[n] = 0;

        while (!q.isEmpty()) {
            int now = q.remove();
            int next;

            if (now == k) break;

            for (int i = 0; i < 3; i++) {
                if (i == 2) next = now * move_state[i];
                else next = now + move_state[i];

                if (next < 0 || next >= MAX) continue;

                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    times[next] = times[now] + 1;
                    from[next] = now;
                }
            }
        }

        System.out.println(times[k]);
        Stack<Integer> stack = new Stack<>();
        stack.push(k);

        // 이렇게 하면 n : 5, k : 17일 때, 최소시간이 4인데
        // 4보다 더 돌 가능성이 있을 수 있다.
        /*while (from[temp] != 0) {
            stack.push(from[temp]);
            temp = from[temp];
        }*/

        int limit = times[k];
        while (limit-- > 0) {
            k = from[k];
            stack.push(k);
        }

        while (!stack.isEmpty()) {
            if (stack.size() == 1) System.out.print(stack.pop());
            else System.out.print(stack.pop() + " ");
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
