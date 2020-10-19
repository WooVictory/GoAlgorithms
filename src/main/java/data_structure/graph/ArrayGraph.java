package data_structure.graph;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/10/14
 */
public class ArrayGraph {
    private int size;
    private int[][] arrayGraph;
    private boolean[] visited;

    public ArrayGraph(int size) {
        this.size = size;
        this.arrayGraph = new int[size + 1][size + 1];
        this.visited = new boolean[size + 1];
    }

    public int[][] getArrayGraph() {
        return this.arrayGraph;
    }

    // 그래프 추가(양방향)
    public void put(int x, int y) {
        arrayGraph[x][y] = arrayGraph[y][x] = 1;
    }

    // 그래프 추가(양방향, 가중치 있는 경우)
    public void put(int x, int y, int weight) {
        arrayGraph[x][y] = arrayGraph[y][x] = weight;
    }

    public void putSingle(int x, int y) {
        arrayGraph[x][y] = 1;
    }

    public void printGraph() {
        for (int i = 0; i < arrayGraph.length; i++) {
            for (int j = 0; j < arrayGraph[i].length; j++) {
                System.out.print(" " + arrayGraph[i][j]);
            }
            System.out.println();
        }
    }

    public void clearVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    /*
     * 그래프 탐색(재귀 호출)
     * dfs 호출에 사용되는 index 는 방문한 것이므로
     * 방문 배열의 index 값을 true 로 바꿔준다.
     *
     * 인접 행렬로 구현된 그래프에서 정점의 갯수만큼 탐색한다.
     * arrayGraph[][]의 해당 정점이 연결되어 있고(1로 표시) 방문한 적이 없는 정점의 경우
     * dfs 탐색을 호출한다.
     * */
    public void dfs(int index) {
        visited[index] = true;
        System.out.print(index + " ");

        for (int i = 1; i <= size; i++) {
            if (arrayGraph[index][i] == 1 && !visited[i]) dfs(i);
        }
    }


    public void bfs(int index) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();
            System.out.print(cur + " ");

            for (int i = 1; i <= size; i++) {
                if (arrayGraph[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
