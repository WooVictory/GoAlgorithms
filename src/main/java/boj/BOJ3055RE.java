package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * created by victory_woo on 2020/09/02
 * 탈출 Review.
 */
public class BOJ3055RE {
    private static int r, c;
    private static char[][] map;
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        r = toInt(in[0]);
        c = toInt(in[1]);

        map = new char[r][c];
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        solve();
        System.out.println(result == Integer.MAX_VALUE ? "KAKTUS" : result);
    }

    private static void solve() {
        LinkedList<Node> q = new LinkedList<>();
        findWater(q); // 먼저, 물이 있는 곳을 찾아서 큐에 넣어준다.
        findHedgehog(q); // 다음으로 고슴도치가 있는 곳을 찾아서 큐에 넣어준다.

        // 큐에는 [물,물, ... , 고슴도치] 순서로 들어있다.
        // 따라서 탐색을 하게 된다면 물 -> 고슴도치 -> 물 -> 고슴도치 순서로 진행한다.
        // 이로 인해서 고슴도치는 다음에 물이 찰 예정인 칸에 방문하지 않을 수 있다.
        while (!q.isEmpty()) {
            Node now = q.remove();
            int x = now.x, y = now.y, time = now.time;
            char current = now.current;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (visit[nx][ny]) continue;

                // 현재 물인 경우.
                // 다음으로 갈 공간이 빈 공간이어야만 이동하여 물이 퍼질 수 있다.
                // 물이 퍼진 시간은 고려 대상이 아니기 때문에 현재 시간과 동일하게 넣어준다.
                if (current == '*') {
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        visit[nx][ny] = true;
                        q.add(new Node(nx, ny, time, '*'));
                    }
                }

                // 현재가 고슴도치인 경우.
                // 빈 공간이나 비버의 굴로 이동할 수 있으며, 돌이 있는 곳은 갈 수 없다.
                // 고슴도치가 다음 공간으로 이동했기 때문에 time 을 1 증가시켜준다.
                if (current == 'S') {
                    if ((map[nx][ny] == '.' || map[nx][ny] == 'D') && map[nx][ny] != 'X') {
                        // 비버의 굴에 도착한 경우, time 을 넣어주고 함수를 종료한다.
                        if (map[nx][ny] == 'D') {
                            result = time;
                            return;
                        }
                        visit[nx][ny] = true;
                        map[nx][ny] = 'S';
                        q.add(new Node(nx, ny, time + 1, 'S'));
                    }
                }
            }
        }
    }

    // 물의 위치를 찾아서 큐에 넣는다.
    private static void findWater(Queue<Node> q) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') q.add(new Node(i, j, 0, '*'));
            }
        }
    }

    // 고슴도치의 위치를 찾아서 큐에 넣는다.
    private static void findHedgehog(Queue<Node> q) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') q.add(new Node(i, j, 1, 'S'));
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int x;
        int y;
        int time;
        char current;

        Node(int x, int y, int time, char current) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.current = current;
        }
    }
}
