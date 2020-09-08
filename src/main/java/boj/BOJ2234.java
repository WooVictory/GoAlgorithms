package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/08
 */
public class BOJ2234 {
    private static int m, n;
    private static Node[][] map;
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int maxRoom = 0;
    private static ArrayList<Integer> list = new ArrayList<>();
    // 각 방마다 몇개의 방이 있는지 저장한다.
    // 1번 방은 9개, 2번 방은 3개,,.. 이런 식이다.

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

                // 이진수로 변환해서 벽의 정보를 map 2차원 배열에 저장해버린다.
                findWall(binary, node);
                map[i][j] = node;
            }
        }

        // 전체적으로 방이 몇 개 있는지 확인.
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
                findMaxSize(i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j].roomNumber + " ");
            }
            System.out.println();
        }

        System.out.println(countOfRoom);
        System.out.println(maxRoom);
        System.out.println(max);
        System.out.println(list);
    }

    private static void findWall(String binary, Node node) {
        for (int k = binary.length() - 1; k >= 0; k--) {
            char ch = binary.charAt(k);

            if (ch == '1') {
                int value = (int) Math.pow(2, binary.length() - k - 1);
                switch (value) {
                    case 1: // 서쪽.
                        node.s = 1;
                        break;
                    case 2: // 북쪽.
                        node.b = 1;
                        break;
                    case 4: // 동쪽.
                        node.d = 1;
                        break;
                    case 8: // 남쪽.
                        node.n = 1;
                        break;
                }
            }
        }
    }

    // roomNumber 는 0부터 시작한다. 인덱스와 동일!
    private static void bfs(int x, int y, int number) {
        int count = 0; // 방의 크기가 얼마나 되는지 확인한다.

        LinkedList<Node> q = new LinkedList<>();
        map[x][y].roomNumber = number;
        q.add(new Node(x, y, map[x][y].d, map[x][y].s, map[x][y].n, map[x][y].b, number));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (visit[nx][ny]) continue;

                map[nx][ny].roomNumber = number;

                // 벽이 아닌 경우를 큐에 넣어줌으로써 방의 갯수를 구해야 한다.
                // 즉, 방인 경우에 큐에 넣어준다.
                switch (i) {
                    case 0:
                        // 남쪽인 경우
                        // 0이라면 벽이 아니므로 큐에 넣어준다.
                        if (cur.n == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                    case 1:
                        // 북쪽인 경우.
                        if (cur.b == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                    case 2:
                        // 동쪽인 경우.
                        if (cur.d == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                    case 3:
                        // 서쪽인 경우.
                        if (cur.s == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                }
            }
        }

        // 가장 넓은 방의 크기를 구한다.
        maxRoom = Math.max(maxRoom, count);
        list.add(count);
        // roomNumber 별로 몇 개의 방이 존재하는지 확인한다.
        // 0번 방 - 9개
        // 1번 방 - 3개
        // 이런 방식이다.
    }

    private static int max = 0;

    // 모든 좌표에 대해서 탐색을 해본다.
    // 현재 방 번호를 알고 있으니까 인접해 있는 다른 방(방 번호가 다름)를 찾아서 비교하면 된다.
    // 동,서,남,북 방향으로 벽이 있다면 그 벽을 기준으로 다른 방이 존재할 때 두 방의 갯수를 합한 값을 계산하여
    // 두 방을 합쳐서 얻을 수 있는 가장 넓은 방의 크기를 갱신해나간다. -> 이게 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기가 된다.
    private static void findMaxSize(int x, int y) {
        Node cur = map[x][y];
        int count = list.get(cur.roomNumber);
        // number 에 해당하는 방은 몇개가 존재하는지 갯수를 가져온다. -> 현재 방번호의 방 갯수.

        for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            switch (i) {
                case 0:
                    // 남쪽 방향에 벽이 존재한다면
                    // 다음 방의 방 번호와 현재 방의 방 번호가 다르다면 두 방의 갯수를 합쳐서
                    // max 를 갱신한다.
                    if (cur.n == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            max = Math.max(max, count + list.get(map[nx][ny].roomNumber));
                            // 현재 방번호의 방 갯수 : count
                            // 다음 방 번호를 알고 있으니, 방번호별로 몇개의 방이 존재하는지 알고 있는 list 에서
                            // 방번호를 사용하여 방의 갯수를 구해온다.
                            // 그리고 둘의 합을 구한다.
                        }
                    }
                    break;
                case 1:
                    // 북쪽 방향에 벽이 존재한다면
                    if (cur.b == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            max = Math.max(max, count + list.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
                case 2:
                    // 동쪽인 경우.
                    if (cur.d == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            max = Math.max(max, count + list.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
                case 3:
                    // 서쪽인 경우.
                    if (cur.s == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            max = Math.max(max, count + list.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
            }
        }
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
