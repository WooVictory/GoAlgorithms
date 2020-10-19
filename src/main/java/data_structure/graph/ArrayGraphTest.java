package data_structure.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/10/14
 */
public class ArrayGraphTest {
    public static void main(String[] args) throws IOException {
        //graphTest();

        //dfsTest();

        bfsTest();
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

    /*
    * test
    * 6 16
1 6
1 5
2 3
2 4
2 6
3 2
3 4
3 5
4 2
4 3
5 1
5 3
5 6
6 1
6 2
6 5
    *
    * */
    private static void bfsTest() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int v = Integer.parseInt(in[0]), e = Integer.parseInt(in[1]);


        ArrayGraph graph = new ArrayGraph(v);
        for (int i = 0; i < e; i++) {
            in = br.readLine().split(" ");
            int v1 = toInt(in[0]), v2 = toInt(in[1]);

            graph.put(v1, v2);
        }

        graph.printGraph();
        System.out.print("정점 1부터 탐색 : ");
        graph.bfs(1);
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
