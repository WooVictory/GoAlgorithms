package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/14
 */
public class BOJ1707RE {
    private static ArrayList<Integer>[] a;
    private static int[] check;
    private static final int RED = 1;
    private static final int BLUE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = toInt(br.readLine());

        while (k-- > 0) {
            String[] in = br.readLine().split(" ");
            int v = toInt(in[0]), e = toInt(in[1]);
            a = new ArrayList[v + 1];
            check = new int[v + 1];

            for (int i = 1; i <= v; i++) a[i] = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                in = br.readLine().split(" ");
                int v1 = toInt(in[0]), v2 = toInt(in[1]);

                a[v1].add(v2);
                a[v2].add(v1);
            }

            // bfs, dfs 모두 가능하다.
            for (int i = 1; i <= v; i++) {
                if (check[i] == 0) {
                    //bfs(i, RED);
                    dfs(i, RED);
                }
            }

            // 정점을 확인하며, 연결된 정점들이 기준이 되는 정점과 같은 색으로 칠해져있다면
            // 이분 그래프가 아니므로 flag 값을 false 로 변경한다.
            // 그렇지 않다면 flag 는 true 로 이분 그래프가 된다.
            boolean flag = true;
            for (int i = 1; i <= v; i++) {
                for (int vv : a[i]) {
                    if (check[vv] == check[i]) {
                        flag = false;
                        break;
                    }
                    if (!flag) break;
                }
            }

            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void bfs(int v, int color) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(v);
        check[v] = color; // 해당 정점에 color 색상을 칠한다.

        while (!q.isEmpty()) {
            int cur = q.remove(); // 큐에서 정점을 꺼낸다.

            // 꺼낸 정점과 연결된 즉, 인접한 정점들을 확인한다.
            for (int vv : a[cur]) {
                // 색상이 칠해져 있지 않은 경우
                // 큐에 넣고 인접한 정점을 현재 정점과 다른 색으로 칠한다.
                if (check[vv] == 0) {
                    q.add(vv);
                    check[vv] = -check[cur];
                    // cur 정점과 연결된 vv 에 해당하는 정점이 다른 색으로 칠해져야 한다.
                }
            }
        }
    }

    // dfs 탐색이며, 로직은 동일하다.
    private static void dfs(int start, int color) {
        check[start] = color;

        for (int vv : a[start]) {
            if (check[vv] == 0) dfs(vv, -check[start]);
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
