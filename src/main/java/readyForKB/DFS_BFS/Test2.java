package readyForKB.DFS_BFS;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/11/10
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));

        System.out.println(solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        }));
    }

    /*
     * 두번째 접근방법.
     * 처음에는 2차원 배열로 접근을 했었다. 예제 테스트 케이스에 대해 답은 나왔지만,
     * 히든에서 거의 다 틀렸다.
     *
     * 틀린 이유를 생각해보니, i가 정점 하나로 존재하기 때문이다.
     * 그래서 visited 배열도 정점에 대해서만 관리를 한다.
     * 큐에 들어갈 때도 정점 자체가 들어간다. 2차원으로 접근할 경우, 왜 틀리는지는 살짝 이해가 안간다..
     * 왜냐면 어차피 풀이는 조금 달라도 탐색은 같을 텐데 말이다.. 흠흠.
     * */
    private static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                //bfs(i, computers, n);
                dfs(i, computers, n);
            }
        }
        return count;
    }

    private static void dfs(int v, int[][] computers, int n) {
        if (visited[v]) return;
        visited[v] = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[v][i] == 1) dfs(i, computers, n);
        }
    }

    private static void bfs(int v, int[][] computers, int n) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();

            for (int i = 0; i < n; i++) {
                if (!visited[i] && computers[cur][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    /*
     * 첫번째 접근 방법.
     * */
    /*private static void bfs(int x, int y, int[][] computers, int n) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.remove();
            x = cur.x;
            y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (computers[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }*/

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
