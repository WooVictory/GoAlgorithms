package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/09/02
 */
public class BOJ11403RE {
    private static int n;
    private static int[][] a;
    private static int[][] path;
    private static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = toInt(br.readLine());

        a = new int[n][n];
        path = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = toInt(in[j]);
            }
        }

        // 행을 기준으로 깊게 탐색해 나간다.
        // 이 행에 존재하는 연결된 정점부터 끝까지 탐색하여 현재 정점에서 방문하는 정점들과의 간선이 존재한다면
        // visit 배열을 1로 체크하여 방문했음을 나타내고 이는 정점이 연결되어 있음을 뜻한다.
        for (int i = 0; i < n; i++) {
            visit = new int[n];
            dfs(i);

            // 연결된 정점들을 path 배열에 표시한다.
            for (int j = 0; j < n; j++) {
                path[i][j] = visit[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int v) {
        // v 정점에서 연결된 다른 정점들을 확인한다.
        // 연결되었다면 1이고, 방문한 적이 없는 정점들을 방문해야 한다.
        // 조건을 만족하면 1로 체크하고 그 정점에서 또 연결된 다른 정점을 방문하기 위해 dfs 호출한다.
        for (int i = 0; i < n; i++) {
            if (a[v][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                dfs(i);
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}