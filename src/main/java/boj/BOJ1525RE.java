package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/14
 */
public class BOJ1525RE {
    private static final int target = 123456789;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

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

        // 2차원 배열을 사용하지는 않는다.
        // 다만, 2차원의 형태로 입력을 받되 flat 하게 펼친다.
        // 쉽게 접근하기 위해 int 로 다룬다.
        bfs(start);
    }

    // map : 해당 숫자를 만들기 위해서 이동한 횟수를 저장한다.
    // start 를 큐에 넣고 시작하며, map 에도 넣는다. 이때는 이동횟수가 없기 때문에 0이다.
    private static void bfs(int start) {
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.add(start);
        map.put(start, 0);

        while (!q.isEmpty()) {
            int cur = q.remove(); // 큐에서 뺀다.
            String num = String.valueOf(cur); // 숫자를 문자열로 변환한다.
            int nineIndex = num.indexOf('9'); // 0의 인덱스를 찾는다.
            int x = nineIndex / 3;
            int y = nineIndex % 3;
            // 인덱스를 기반으로 2차원 배열에서 9의 x,y 좌표를 찾는다.

            // 동,서,남,북 네 방향을 탐색하며 이동할 수 있는 공간을 찾는다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx, ny)) continue;

                // 범위를 벗어나지 않는다면, 9는 상하좌우로 이동할 수 있다.
                StringBuilder sb = new StringBuilder(num);
                int nextIndex = 3 * nx + ny; // 다음으로 이동할 인덱스를 좌표를 이용하여 구한다.
                char next = sb.charAt(nextIndex); // 다음에 이동할 좌표의 문자를 찾는다.
                sb.setCharAt(nineIndex, next);
                sb.setCharAt(nextIndex, '9');
                // 9와 찾은 문자의 위치를 교환해준다.

                // 숫자로 다시 만들어서 map 에 포함되어 있는지 확인한다.
                int nextNum = toInt(sb.toString());
                if (!map.containsKey(nextNum)) {
                    // 포함되어 있지 않다면, map 에 해당 숫자를 넣어주며
                    // cur 로부터 이동횟수 1을 추가한다.
                    map.put(nextNum, map.get(cur) + 1);
                    // 큐에도 넣어준다.
                    q.add(nextNum);
                }
            }
        }

        // 탐색을 다 돌고 나와서 target 이 map 에 존재한다면 target 을 만드는 데 걸린 이동횟수를 출력.
        // 만들지 못했다면 -1을 반환한다.
        if (map.containsKey(target)) System.out.println(map.get(target));
        else System.out.println(-1);
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < 3 && 0 <= y && y < 3;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int x;
        int y;
        int distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}