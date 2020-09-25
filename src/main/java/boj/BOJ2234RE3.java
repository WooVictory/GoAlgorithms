package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/25
 */
public class BOJ2234RE3 {
    private static int m, n;
    private static Node[][] map;
    private static boolean[][] visit;
    private static int maxSizeOfRoom = Integer.MIN_VALUE;
    private static HashMap<Integer, Integer> hm = new HashMap<>();
    private static int result = Integer.MIN_VALUE;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    // 남동북서.

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

                // binary 를 통해 동,서,남,북 방향의 벽 정보를 업데이트하여 map 배열을 초기화한다.
                setWall(binary, node);
                map[i][j] = node;
            }
        }

        // 1. 이 성에 몇개의 방이 있는지 확인한다.
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
        System.out.println(maxSizeOfRoom);
        System.out.println(result);
    }

    private static void bfs(int x, int y, int roomNumber) {
        LinkedList<Node> q = new LinkedList<>();
        Node node = map[x][y];
        map[x][y].roomNumber = roomNumber;
        q.add(new Node(x, y, node.d, node.s, node.n, node.b, roomNumber));
        visit[x][y] = true;
        int count = 0; // 각 방의 넓이를 계산한다.

        while (!q.isEmpty()) {
            Node cur = q.remove();
            x = cur.x;
            y = cur.y;
            count++; // 이동할 수 있는 방의 크기가 몇개인지 카운트한다.

            // 상하좌우를 돌면서 다음 탐색할 공간의 좌표를 찾는다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어나거나 이미 방문한 적이 있으면 건너뛴다.
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (visit[nx][ny]) continue;

                // 연결된 방들은 동일한 roomNumber 를 갖는다.
                map[nx][ny].roomNumber = roomNumber;

                // 현재 노드에서 남동북서 방향을 확인하면서
                // 벽이 없는 곳을 탐색하기 위해 큐에 넣고 방문 여부를 체크한다.
                // 벽이 없어야 방이 연결된다.
                // 0 : 길, 1 : 벽이므로 갈 수 없음.
                switch (i) {
                    case 0:
                        if (cur.n == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                    case 1:
                        if (cur.d == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                    case 2:
                        if (cur.b == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                    case 3:
                        if (cur.s == 0) {
                            q.add(map[nx][ny]);
                            visit[nx][ny] = true;
                        }
                        break;
                }
            }
        }

        // 2. 방의 넓이 중 최대 넓이를 찾는다.
        // 각 방의 넓이를 찾을 때마다 maxSizeOfRoom 값을 갱신하여 가장 넓은 방의 넓이를 찾는다.
        maxSizeOfRoom = Math.max(maxSizeOfRoom, count);
        // roomNumber - count 저장한다. 방별로 크기를 저장한다.
        hm.put(roomNumber, count);
    }

    // ex) 11 -> 1011(남동북서)
    private static void setWall(String binary, Node node) {
        for (int k = binary.length() - 1; k >= 0; k--) {
            if (binary.charAt(k) == '0') continue; // 여기서 또 실수...

            int value = (int) Math.pow(2, binary.length() - k - 1);

            // 8 4 2 1
            // 1 0 1 1
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

    // 3. 벽을 하나 없앴을 때, 두 방의 넓이 중 최대값을 찾는다.
    // 남동북서.
    private static void getTwoRoomMaxSize(int x, int y) {
        Node cur = map[x][y];
        int count = hm.get(cur.roomNumber);
        // 현재 노드인 cur 이 속한 방은 몇 개가 있는가?(방의 넓이)

        // 현재 노드 기준으로 남동북서 방향을 확인한다.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어나면 건너뛴다.
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

            // 현재 노드에서 남동북서 방향으로 탐색하며, 각 방향에 도달했을 때 그 방향 쪽으로 벽이 존재하는지 확인한다.
            // 벽이 있다면 벽 건너편에는 다른 번호의 방이 있을 수 있다.
            // 서로 방 번호가 다르다면 두 방의 크기를 합하여 두 방의 크기 합 중 최대를 찾아나간다.
            // 이 경우가 벽을 하나 없앴을 때, 두 방의 크기 합 중 최대를 구하는 부분이 된다.
            switch (i) {
                case 0: // 남
                    // 남쪽에 벽이 있어야 벽을 기준으로 서로 다른 두 방의 크기를 합쳤을 때, 최대 값을 구할 수 있다.
                    if (cur.n == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            result = Math.max(result, count + hm.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
                case 1:
                    if (cur.d == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            result = Math.max(result, count + hm.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
                case 2:
                    if (cur.b == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            result = Math.max(result, count + hm.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
                case 3:
                    if (cur.s == 1) {
                        if (cur.roomNumber != map[nx][ny].roomNumber) {
                            result = Math.max(result, count + hm.get(map[nx][ny].roomNumber));
                        }
                    }
                    break;
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    // node 클래스를 이용하여 동,서,남,북 방향에 벽의 정보를 저장한다.
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
