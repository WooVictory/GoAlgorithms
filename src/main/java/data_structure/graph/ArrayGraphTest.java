package data_structure.graph;

/**
 * created by victory_woo on 2020/10/14
 */
public class ArrayGraphTest {
    public static void main(String[] args) {
        //graphTest();

        dfsTest();
    }

    private static void graphTest() {
        ArrayGraph graph = new ArrayGraph(6);

        graph.put(1, 2);
        graph.put(1, 3);
        graph.put(2, 3);
        graph.put(2, 4);
        graph.put(3, 4);
        graph.put(3, 5);
        graph.put(4, 5);
        graph.put(4, 6);

        graph.printGraph();
    }

    private static void dfsTest() {
        ArrayGraph graph = new ArrayGraph(8);
        graph.put(1, 2);
        graph.put(1, 3);
        graph.put(2, 4);
        graph.put(2, 5);
        graph.put(3, 6);
        graph.put(3, 7);
        graph.put(4, 8);
        graph.put(5, 8);
        graph.put(6, 8);
        graph.put(7, 8);


        graph.printGraph();
        System.out.print("정점 1부터 탐색 : ");
        graph.dfs(1);

        System.out.println();
        System.out.print("정점 2부터 탐색 : ");
        graph.clearVisited();
        graph.dfs(2);
    }
}
