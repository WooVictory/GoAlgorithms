package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * created by victory_woo on 2020/09/02
 */
public class BOJ9019 {
    private static final int MAX = 10000;
    private static boolean[] visit;
    private static char[] commands;
    private static int[] from;
    private static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = toInt(br.readLine());
        while (t-- > 0) {
            String[] in = br.readLine().split(" ");
            a = toInt(in[0]);
            b = toInt(in[1]);
            visit = new boolean[MAX + 1];
            commands = new char[MAX + 1];
            from = new int[MAX + 1];

            bfs(a, b);
        }
    }

    private static void bfs(int a, int b) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(a);
        visit[a] = true;
        commands[a] = ' ';

        while (!q.isEmpty()) {
            int now = q.remove();

            if (now == b) break;

            // D 연산.
            executeD(q, now);

            // S 연산.
            executeS(q, now);

            // L 연산.
            executeL(q, now);

            // R 연산.
            executeR(q, now);
        }

        getResult();
    }

    private static void executeD(Queue<Integer> q, int now) {
        int next = 2 * now;
        if (MAX - 1 < next) next = next % MAX;

        if (!visit[next]) {
            from[next] = now;
            visit[next] = true;
            commands[next] = 'D';
            q.add(next);
        }
    }

    private static void executeS(Queue<Integer> q, int now) {
        int next = now - 1;
        if (next == -1) next = MAX - 1; // 맞음.

        if (!visit[next]) {
            from[next] = now;
            visit[next] = true;
            commands[next] = 'S';
            q.add(next);
        }
    }

    private static void executeL(Queue<Integer> q, int now) {
        int next = (now % 1000) * 10 + now / 1000;

        if (!visit[next]) {
            from[next] = now;
            visit[next] = true;
            commands[next] = 'L';
            q.add(next);
        }
    }

    private static void executeR(Queue<Integer> q, int now) {
        int next = (now % 10) * 1000 + now / 10;

        if (!visit[next]) {
            from[next] = now;
            visit[next] = true;
            commands[next] = 'R';
            q.add(next); // 큐에 넣는걸 빼먹음..
        }
    }

    private static void getResult() {
        StringBuilder sb = new StringBuilder();
        while (a != b) {
            sb.append(commands[b]);
            b = from[b];
        }

        System.out.println(sb.reverse().toString());
        // 출력부 역순으로 해줘야 함.
        // 그래야 올바른 순서(앞에서부터)
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
