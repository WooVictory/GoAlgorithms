package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/01
 */
public class BOJ3055WithTwoQueue {
    private static char[][] map;
    private static boolean[][] visit;
    private static int R, C;
    private static LinkedList<Node> water = new LinkedList<>();
    private static LinkedList<Node> hedgehog = new LinkedList<>();
    private static int time = 0;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        R = toInt(in[0]);
        C = toInt(in[1]);

        map = new char[R][C];
        visit = new boolean[R][C];

        // 2개의 큐를 사용한다.
        // water : 물이 있는 위치를 저장.
        // hedgehog : 고슴도치의 위치를 저장.
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '*') {
                    water.add(new Node(i, j));
                    visit[i][j] = true;
                }

                if (map[i][j] == 'S') {
                    hedgehog.add(new Node(i, j));
                    visit[i][j] = true;
                }
            }
        }

        bfs();
        // flag 값이 false 라면 고슴도치가 비버의 굴에 도착하지 못했음을 의미하기 때문에 "KAKTUS"를 출력한다.
        // 비버의 굴에 도착했다면 flag = true 이므로 최소시간인 time 출력.
        System.out.println(flag ? time : "KAKTUS");
    }

    private static void bfs() {
        while (!hedgehog.isEmpty()) {
            // 먼저, 물이 퍼진다.
            waterMove();
            // 시간을 증가시킨다.
            time++;

            // 이제 고슴도치가 다음 위치로 이동한다.
            // 이렇게 해야 큐에서 뺐을 때, 무한루프에 빠지지 않는다.
            int size = hedgehog.size();
            while (size-- > 0) {
                Node now = hedgehog.remove();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (isOutOfRange(nx, ny)) continue;
                    if (visit[nx][ny]) continue;

                    // 고슴도치가 비버의 굴에 도착했다면, 정답을 찾았으므로 flag 를 변경하고
                    // 함수를 return 한다.
                    if (map[nx][ny] == 'D') {
                        flag = true;
                        return;
                    }

                    // 빈 곳이라면 이동하여 큐에 넣어준다.
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'S';
                        visit[nx][ny] = true;
                        hedgehog.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    // 이렇게 해야 처음에 물이 있는 위치만 퍼지게 된다.
    // 물은 빈 곳에 퍼질 수 있기 때문에 다음 위치가 빈 곳이어야만 물을 퍼트리고 방문 여부를 체크한다.
    // 그리고 큐에 물의 위치를 넣는다.
    private static void waterMove() {
        int size = water.size();
        while (size-- > 0) {
            Node now = water.remove();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isOutOfRange(nx, ny)) continue;
                if (visit[nx][ny]) continue;

                if (map[nx][ny] == '.') {
                    visit[nx][ny] = true;
                    map[nx][ny] = '*';
                    water.add(new Node(nx, ny));
                }
            }
        }
    }

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= R || y >= C;
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
