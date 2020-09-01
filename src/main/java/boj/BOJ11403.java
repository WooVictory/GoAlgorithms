package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/01
 */
public class BOJ11403 {
    private static int N;
    private static int[][] map;
    private static ArrayList<Integer>[] a;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(br.readLine());

        map = new int[N][N];
        a = new ArrayList[N];

        for (int i = 0; i < N; i++) a[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = toInt(in[j]);
                if (value == 1) a[i].add(j);
            }
        }

        int row;
        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            row = i;
            bfs(row, i);
        }

        print(map);
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int row, int v) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(v);

        while (!q.isEmpty()) {
            int now = q.remove();

            for (int vv : a[now]) {
                if (!visit[vv]) {
                    visit[vv] = true;
                    map[row][vv] = 1;
                    q.add(vv);
                }
            }
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}