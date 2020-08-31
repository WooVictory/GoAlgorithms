package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/31
 */
public class BOJ1707 {
    private static ArrayList<Integer>[] a;
    private static int[] colors;
    private static final int RED = 1;
    private static final int BLUE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = toInt(br.readLine());

        while (test_case-- > 0) {
            String[] in = br.readLine().split(" ");
            int v = toInt(in[0]), e = toInt(in[1]);

            a = new ArrayList[v + 1];
            colors = new int[v + 1];

            for (int i = 1; i <= v; i++) a[i] = new ArrayList<>();

            // 양방향 그래프(무방향 그래프)
            for (int i = 0; i < e; i++) {
                in = br.readLine().split(" ");
                int v1 = toInt(in[0]), v2 = toInt(in[1]);

                a[v1].add(v2);
                a[v2].add(v1);
            }

            // colors[i]가 0이라면 방문한 적이 없는 정점이기 때문에
            // 해당 정점을 방문하면서 RED(빨간색)으로 칠해준다.
            for (int i = 1; i <= v; i++) {
                if (colors[i] == 0) {
                    //bfs(i, RED);
                    dfs(i, RED);
                }
            }

            boolean isBipartiteGraph = true;
            for (int i = 1; i <= v; i++) {
                for (int vv : a[i]) {
                    if (colors[i] == colors[vv]) isBipartiteGraph = false;
                }
            }

            System.out.println(isBipartiteGraph ? "YES" : "NO");
        }
    }

    private static void dfs(int start, int color) {
        colors[start] = color;

        for (int v : a[start]) {
            if (colors[v] == 0) dfs(v, -colors[start]);
        }
    }

    private static void bfs(int start, int color) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(start); // 큐에 넣어준다.
        colors[start] = color; // 초기 색을 칠해준다.

        while (!q.isEmpty()) {
            int now = q.remove();

            for (int v : a[now]) {
                // 색이 안칠해져있다면 방문한 적이 없는 경우이다.
                if (colors[v] == 0) {
                    q.add(v); // 큐에 넣는다.
                    colors[v] = -colors[now]; // 인접한 정점에 자신과 다른 색을 칠해준다.
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
