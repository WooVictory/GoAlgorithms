package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/26
 * 단지 번호 붙이기.
 */
public class BOJ2667 {
    private static int[][] map, copy;
    private static boolean[][] visit;
    private static int N, answer = 0;
    private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    private static ArrayList<Integer> result = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(br.readLine());

        map = new int[N][N];
        copy = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < input.length; j++) {
                map[i][j] = toInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    answer++;
                    //bfs(i, j);

                    // dfs
                    count = 0;
                    copy[i][j] = answer;
                    dfs(i, j);

                    result.add(count);
                }
            }
        }


        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) sb.append(result.get(i));
            else sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb.toString());

        // 확인용.
        System.out.println(answer);
        System.out.println(result);
        print(copy);
    }

    // dfs 탐색.
    private static void dfs(int x, int y) {
        count++;
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isOutOfRange(nx, ny)) continue;

            if (!visit[nx][ny] && map[nx][ny] == 1) {
                copy[nx][ny] = answer;
                dfs(nx, ny);
            }
        }
    }

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    // bfs 탐색.
    private static void bfs(int x, int y) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        copy[x][y] = answer;
        int count = 1;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            x = cur.x;
            y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isOutOfRange(nx, ny)) continue;

                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    copy[nx][ny] = answer;
                    visit[nx][ny] = true;
                    count++;
                }
            }
        }
        result.add(count);
    }

    private static void print(int[][] a) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
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
