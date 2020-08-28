package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/28
 */
public class BOJ7576 {
    private static int M, N;
    private static int[][] map;
    private static boolean[][] visit;
    private static LinkedList<Tomato> q = new LinkedList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        M = toInt(in[0]);
        N = toInt(in[1]);

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = toInt(in[j]);

                // 1. 토마토가 있는 지점을 미리 큐에 넣는다.
                if (map[i][j] == 1) {
                    q.add(new Tomato(i, j));
                    visit[i][j] = true;
                }
            }
        }

        // 2. 처음부터 모두 익었는지 아닌지 확인한다.
        // 모두 익었다면 탐색할 필요 없이 0을 반환하고 끝난다.
        if (check()) System.out.println(0);
        else bfs();

        print(map);
    }


    // 3. bfs 탐색을 시작한다.
    private static void bfs() {
        while (!q.isEmpty()) {
            Tomato cur = q.remove();
            int x = cur.x;
            int y = cur.y;

            // 4. 큐에 있는 토마토를 꺼내서 인접한 상,하,좌,우 네 방향을 모두 검사한다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;

                // 익지 않은 토마토의 경우, 0이므로 익지 않은 토마토를 찾아서 익게 만든다.
                // 그리고 그 토마토가 익는데 몇일이 걸리는지를 저장한다.
                // (현재 토마토가 익는데 걸리는 일수 + 1)이 된다.
                if (map[nx][ny] == 0) {
                    q.add(new Tomato(nx, ny));
                    visit[nx][ny] = true;
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }

        // 5. 0인 곳이 하나라도 있는지 확인하기!!
        // 이는 탐색을 했음에도 익지 않은 토마토가 있는지 확인하는 것이다.
        // 빈 공간으로 둘러쌓였던 곳이라면 토마토가 익지 않는다.
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        // 6. 익지 않은 토마토가 하나라도 있기 때문에 -1 반환.
        // 7. 그런 경우가 없기 때문에 정답을 구하러 간다.
        if (!flag) System.out.println(-1);
        else System.out.println(findMax());
    }

    // 8. 2차원 배열 중에서 최대값을 찾는다.
    private static int findMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (max < map[i][j]) max = map[i][j];
            }
        }

        // 9. 이 최대값에서 1을 빼면 모든 토마토가 익는데 걸리는 최소 일수가 된다.
        // 1을 빼주는 이유는 토마토를 나타내는 1을 1일로 생각하여 시작했기 때문에 다음부터 바로 2일, 3일, ...
        // 이 되면서 원래 정답보다 1일 더 큰 답이 나오게 되어서 1을 빼주면 된다.
        return max - 1;
    }

    private static void print(int[][] a) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean check() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static class Tomato {
        int x;
        int y;

        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
