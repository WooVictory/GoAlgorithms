package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * created by victory_woo on 2020/09/04
 */
public class BOJ2146 {
    private static int N;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[][] distance;
    private static int count = 0;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static ArrayList<Integer> result = new ArrayList<>();
    private static LinkedList<Node> islands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(br.readLine());

        map = new int[N][N];
        distance = new int[N][N];
        visit = new boolean[N][N];
        islands = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = toInt(in[j]);
                // 2. 간척 사업을 위해 각 섬을 큐에 넣는다.
                if (map[i][j] == 1) islands.add(new Node(i, j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] != 0) {
                    // 1. 탐색을 통해서 각 섬에 번호를 지정해준다.
                    count++;
                    setNumberIsland(i, j);
                }
            }
        }

        // 섬들의 위치를 기반으로 탐색을 진행한다.
        bfs(islands);

        // 4. 측정된 경로 중 가장 짧은 경로를 출력한다.
        System.out.println(Collections.min(result));
    }

    // 큐에 섬들이 들어가있으므로 간척 사업을 진행한다.
    private static void bfs(Queue<Node> q) {
        while (!q.isEmpty()) {
            Node cur = q.remove();
            int x = cur.x, y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx, ny)) continue;

                // 3. 간척 사업 과정 중에 서로 다른 섬이 만날 때, 경로를 측정하여 저장한다.
                if (map[nx][ny] != 0 && map[nx][ny] != map[x][y]) {
                    result.add(distance[nx][ny] + distance[x][y]);
                }

                // 간척 사업을 위해 바다를 육지로 만들고 큐에 넣어준다.
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y];
                    q.add(new Node(nx, ny));
                    distance[nx][ny] = distance[x][y] + 1;
                }
            }
        }
    }

    private static void setNumberIsland(int x, int y) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        map[x][y] = count;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            x = cur.x;
            y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx, ny)) continue;

                // 방문한 적이 없고, 1인 섬에 번호를 지정하고
                // 간척사업을 위해 각 섬을 큐에 넣는다.
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    q.add(new Node(nx, ny));
                    map[nx][ny] = count;

                    visit[nx][ny] = true;
                }
            }
        }
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
