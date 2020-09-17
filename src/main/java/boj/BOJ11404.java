package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/09/17
 * 플로이드
 * 문제 출처 : https://www.acmicpc.net/problem/11404
 */
public class BOJ11404 {
    private static int n;
    private static int[][] distance;
    private static final int INF = 1000000000;
    //private static final int INF = Integer.MAX_VALUE;
    // 나올 수 없는 값으로 초기화한다.
    // Integer.MAX_VALUE 로 하게 되면 값이 바뀌지 않는다...

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = toInt(br.readLine());

        // distance 배열 초기화.
        // 같은 정점에 대해서는 0으로 초기화하고, 나머지 정점은 무한대로 초기화한다.
        distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                distance[i][j] = i == j ? 0 : INF;
            }
        }

        int m = toInt(br.readLine());
        while (m-- > 0) {
            String[] in = br.readLine().split(" ");
            int v1 = toInt(in[0]), v2 = toInt(in[1]), cost = toInt(in[2]);

            // 같은 정점에 대해서 다른 비용으로 다시 한번 입력이 들어올 수 있기 때문에
            // 여기서 계산하여 최소값을 distance 배열에 할당한다.
            distance[v1][v2] = Math.min(distance[v1][v2], cost);
        }

        solve();

        // 출력한다.
        // 최단 경로가 존재하지 않으면 INF 값이 들어있으므로 0을 출력한다.
        // INF 가 아니라면 자신의 최단 경로 값을 출력한다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (INF <= distance[i][j]) System.out.print("0 ");
                else System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

    }

    // 플로이드 와샬.
    private static void solve() {
        for (int k = 1; k <= n; k++) { // 거쳐가는 정점.
            for (int i = 1; i <= n; i++) { // 출발하는 정점.
                for (int j = 1; j <= n; j++) { // 도착하는 정점.
                    // i에서 j까지 가는 거리와 i에서 k를 거쳤다가 k에서 j까지 가는 거리를 비교하여
                    // 더 작은 값이 나온다면 갱신한다.
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}