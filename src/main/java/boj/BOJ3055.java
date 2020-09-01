package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/01
 */
public class BOJ3055 {
    private static char[][] map;
    private static boolean[][] visit;
    private static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        R = toInt(in[0]);
        C = toInt(in[1]);

        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                map[i][j] = c;
            }
        }

        bfs();
        System.out.println(result == Integer.MAX_VALUE ? "KAKTUS" : result);
    }

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int result = Integer.MAX_VALUE;

    private static void bfs() {
        LinkedList<Node> q = new LinkedList<>();

        // 1. 물인 지점을 찾아서 먼저 큐에 넣는다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') q.add(new Node(i, j, '*', 1));
            }
        }


        // 2. 고슴도치의 위치를 찾아서 큐에 넣는다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') q.add(new Node(i, j, 'S', 1));
            }
        }

        // 큐에 물이 먼저 들어가고 고슴도치가 들어갔기 때문에
        // 물 -> 고슴도치 -> 물 -> 고슴도치 순서로 이어진다.
        while (!q.isEmpty()) {
            Node now = q.remove();
            int x = now.x;
            int y = now.y;
            char c = now.c;
            int time = now.time;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visit[nx][ny]) continue;

                // 물인 경우에는 빈 공간으로만 갈 수 있다.
                if (c == '*') {
                    if (map[nx][ny] == '.') {
                        visit[nx][ny] = true;
                        map[nx][ny] = '*';
                        q.add(new Node(nx, ny, '*', time));
                    }
                }

                // 고슴도치의 경우에는 빈 공간이나 비버의 굴로 이동할 수 있고
                // 돌로는 이동할 수 없다.
                if (c == 'S') {
                    if ((map[nx][ny] == '.' || map[nx][ny] == 'D') && map[nx][ny] != 'X') {
                        visit[nx][ny] = true;
                        // 비버의 굴을 만났다면, 걸린 시간을 저장하고 return 한다.
                        if (map[nx][ny] == 'D') {
                            result = time;
                            return;
                        }

                        map[nx][ny] = 'S';
                        q.add(new Node(nx, ny, 'S', time + 1));
                    }
                }
                //print();
            }
        }
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Node {
        int x;
        int y;
        char c;
        int time;

        Node(int x, int y, char c, int time) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.time = time;
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}