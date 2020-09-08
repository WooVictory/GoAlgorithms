package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/08
 */
public class BOJ11559 {
    private static char[][] map;
    private static boolean[][] visit;
    private static ArrayList<Info> answer;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int count;
        int result = 0;
        do {
            count = 0;
            visit = new boolean[12][6];
            answer = new ArrayList<>();

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visit[i][j]) bfs(i, j, map[i][j]);
                }
            }

            boolean flag = false;
            for (Info info : answer) {
                if (isPossible(info.count)) {
                    flag = true;
                    erase(info.list);
                }
            }

            drop();

            count++;
            if (flag) result += count;
        } while (count != 0);

        System.out.println(result);
    }

    private static boolean isPossible(int count) {
        return 4 <= count;
    }

    private static void drop() {
        for (int c = 0; c < 6; c++) {
            for (int r = 11; r >= 0; r--) {
                if (map[r][c] == '.') {
                    for (int nr = r - 1; nr >= 0; nr--) {
                        if (map[nr][c] != '.') {
                            map[r][c] = map[nr][c];
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void erase(ArrayList<Node> list) {
        for (Node node : list) {
            int x = node.x;
            int y = node.y;

            map[x][y] = '.';
        }
    }

    private static void bfs(int x, int y, char target) {
        ArrayList<Node> result = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        result.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.remove();
            x = cur.x;
            y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if (visit[nx][ny]) continue;

                if (map[nx][ny] == target) {
                    result.add(new Node(nx, ny));
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }

        answer.add(new Info(result));
    }

    static class Info {
        int count;
        Node node;
        ArrayList<Node> list;

        Info(ArrayList<Node> list) {
            this.count = list.size();
            this.list = list;
            if (list.size() > 0) {
                this.node = list.get(0);
            }
        }
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
