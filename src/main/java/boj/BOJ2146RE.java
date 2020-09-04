package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/04
 */
public class BOJ2146RE {
    private static int n;
    private static int[][] map;
    private static int[][] distance;
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static LinkedList<Node> islands;
    private static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = toInt(br.readLine());

        map = new int[n][n];
        distance = new int[n][n];
        visit = new boolean[n][n];
        islands = new LinkedList<>();
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = toInt(in[j]);
                // 1. 섬의 위치를 큐에 저장한다.
                if (map[i][j] == 1) islands.add(new Node(i, j));
            }
        }

        // 섬이 있는 곳의 위치를 찾는다.
        findIsland();
        bfs();
        printMap();
        System.out.println(Collections.min(result));
    }

    private static void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 2. 탐색을 통해 섬이 있는 곳에 번호를 지정하여 구분한다.
    private static void findIsland() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] != 0) {
                    count++;
                    setNumberIsland(i, j, count);
                }
            }
        }
    }

    // 연결된 섬들에게 count 라는 번호를 부여한다.
    private static void setNumberIsland(int x, int y, int count) {
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

                if (!isRange(nx, ny)) continue; // 범위를 벗어나면 Skip.
                if (visit[nx][ny]) continue; // 방문한 적이 있다면 Skip.
                if (map[nx][ny] == 0) continue; // 바다라면 Skip. 섬인 경우에 번호를 부여하는 과정이기 때문!

                // 섬이라면 count 번호를 부여한다.
                if (map[nx][ny] == 1) {
                    map[nx][ny] = count;
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    // 3. 간척사업을 진행한다. 간척사업 과정 중 서로 다른 섬이 만나면 경로를 측정하여 저장한다.
    private static void bfs() {
        while (!islands.isEmpty()) {
            Node cur = islands.remove();
            int x = cur.x, y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx, ny)) continue; // 범위를 벗어나면 Skip.
                if (map[nx][ny] == map[x][y]) continue; // 같은 섬이라면 간척사업은 이미했으니 Skip.

                // 바다가 아닌 육지이지만, 연결된 섬과 다른 섬이라면
                // 서로 다른 섬들 사이의 경로를 측정하여 result 에 저장.
                if (map[nx][ny] != 0 && map[nx][ny] != map[x][y]) {
                    result.add(distance[nx][ny] + distance[x][y]);
                }

                // 바다를 만났다면 간척사업을 진행한다.
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y]; // 간척사업을 진행하여 이전 섬과 같은 값을 저장.
                    islands.add(new Node(nx, ny)); // 큐에 추가한다.
                    distance[nx][ny] = distance[x][y] + 1; // 지나온 경로를 증가시킨다.
                }
            }
        }
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
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
