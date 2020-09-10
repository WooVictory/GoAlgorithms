package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/08
 */
public class BOJ2234RE {
    private static int n, m;
    private static boolean[][] visit;
    private static Node[][] map;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    // 서북동남 순서.
    private static int maxRoomSize = 0;
    private static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = toInt(in[0]);
        m = toInt(in[1]);

        map = new Node[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                String binary = Integer.toBinaryString(toInt(in[j]));
                Node node = new Node(i, j, 0, 0, 0, 0, 0);

                findWall(binary, node);
                map[i][j] = node;
            }
        }


        int countOfRoom = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(i, j, countOfRoom);
                    countOfRoom++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                getTwoRoomMaxSize(i, j);
            }
        }

        System.out.println(countOfRoom);
        System.out.println(maxRoomSize);
        System.out.println(result);
    }

    // 서,북,동,남.
    private static void findWall(String binary, Node node) {
        for (int k = binary.length() - 1; k >= 0; k--) {
            char ch = binary.charAt(k);
            if (ch != '1') continue; // 체크하는 거 실수했었음...!

            int value = (int) Math.pow(2, binary.length() - k - 1);

            switch (value) {
                case 1:
                    node.s = 1;
                    break;
                case 2:
                    node.b = 1;
                    break;
                case 4:
                    node.d = 1;
                    break;
                case 8:
                    node.n = 1;
                    break;
            }
        }
    }

    private static void bfs(int x, int y, int number) {
        LinkedList<Node> q = new LinkedList<>();
        int count = 0;
        Node node = map[x][y];
        map[x][y].roomNumber = number;
        q.add(new Node(x, y, node.d, node.s, node.n, node.b, number));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isOutOfRange(nx, ny)) continue;
                if (visit[nx][ny]) continue;

                map[nx][ny].roomNumber = number;

                switch (i) {
                    case 0:
                        if (cur.s == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                    case 1:
                        if (cur.b == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                    case 2:
                        if (cur.d == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                    case 3:
                        if (cur.n == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                }
            }
        }

        maxRoomSize = Math.max(maxRoomSize, count);
        hm.put(number, count);
    }

    private static int result = 0;

    private static void getTwoRoomMaxSize(int x, int y) {
        Node cur = map[x][y];
        int count = hm.get(cur.roomNumber);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isOutOfRange(nx, ny)) continue;

            switch (i) {
                case 0:
                    if (cur.s == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            result = Math.max(result, count + hm.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
                case 1:
                    if (cur.b == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            result = Math.max(result, count + hm.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
                case 2:
                    if (cur.d == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            result = Math.max(result, count + hm.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
                case 3:
                    if (cur.n == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            result = Math.max(result, count + hm.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
            }
        }
    }

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int x, y;
        int d, s, n, b;
        int roomNumber;

        Node(int x, int y, int d, int s, int n, int b, int roomNumber) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
            this.n = n;
            this.b = b;
            this.roomNumber = roomNumber;
        }
    }
}
