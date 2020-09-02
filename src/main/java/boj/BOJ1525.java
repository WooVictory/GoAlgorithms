package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/02
 */
public class BOJ1525 {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static final int TARGET = 123456789;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = 0;
        for (int i = 0; i < 3; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int value = toInt(in[j]);
                if (value == 0) value = 9;

                start = (start * 10) + value;
            }
        }

        bfs(start);
    }

    private static void bfs(int start) {
        LinkedList<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        q.add(start);
        map.put(start, 0);

        while (!q.isEmpty()) {
            int nowNum = q.remove();
            String now = String.valueOf(nowNum);
            int nineIndex = now.indexOf('9'); // 9의 인덱스.
            int x = nineIndex / 3; // 9가 존재하는 행의 좌표.
            int y = nineIndex % 3; // 9가 존재하는 열의 좌표.

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx, ny)) continue;

                StringBuilder sb = new StringBuilder(now);
                int nextIndex = 3 * nx + ny; // 다음에 이동할 위치의 인덱스.
                char next = sb.charAt(nextIndex); // 다음에 이동할 위치에 있는 문자.
                sb.setCharAt(nextIndex, '9'); // 다음에 이동할 위치에 '9'를 놓는다.
                sb.setCharAt(nineIndex, next); // 9가 있던 곳에는 다음에 이동할 위치에 있는 문자를 놓는다.
                // 서로의 자리를 바꾸게 된다.

                // string -> Int 로 변환하여
                // map 에 저장된 적이 있는지 없는지 판단한다.
                // 없다면 현재 숫자로부터 next 까지 오는데 걸린 이동횟수를 +1하여 이동 횟수를 저장한다.
                int nextNum = toInt(sb.toString());
                if (!map.containsKey(nextNum)) {
                    map.put(nextNum, map.get(nowNum) + 1);
                    q.add(nextNum);
                }
            }
        }

        // 탐색이 끝나고 map 에 target key 저장된 value 가 존재한다면
        // value 즉, 이동횟수를 출력하고 저장된 값이 존재하지 않는다면 -1을 출력한다.
        if (map.containsKey(TARGET)) System.out.println(map.get(TARGET));
        else System.out.println(-1);
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < 3 && 0 <= y && y < 3;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}