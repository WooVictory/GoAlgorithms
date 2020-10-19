package data_structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/10/14
 */
public class ListGraph {
    private int size;
    private ArrayList<Integer>[] listGraph;
    private boolean[] visited;

    public ListGraph(int size) {
        this.size = size;
        this.listGraph = new ArrayList[size + 1];

        for (int i = 0; i <= size; i++) {
            listGraph[i] = new ArrayList<>();
        }

        this.visited = new boolean[size + 1];
    }

    public ArrayList<Integer>[] getGraph() {
        return this.listGraph;
    }

    public ArrayList<Integer> getNode(int i) {
        return this.listGraph[i];
    }

    // 그래프 추가(양방향)
    public void put(int x, int y) {
        listGraph[x].add(y);
        listGraph[y].add(x);
    }

    // 그래프 추가(단방향)
    public void putSingle(int x, int y) {
        listGraph[x].add(y);
    }

    public void printGraph() {
        for (int i = 1; i < listGraph.length; i++) {
            System.out.print("정점 " + i + "의 인접 리스트");

            for (int j = 0; j < listGraph[i].size(); j++) {
                System.out.print("-> " + listGraph[i].get(j));
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
     * 그래프 탐색(재귀호출)
     * */
    public void dfs(int index) {
        visited[index] = true;
        System.out.print(index + " ");

        for (int v : listGraph[index]) {
            if (!visited[v]) dfs(v);
        }
    }

    public void bfs(int index) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;

        while (!q.isEmpty()) {
            int cur = q.remove();
            System.out.print(cur + " ");

            for (int v : listGraph[cur]) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}
