package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * created by victory_woo on 2020/08/30
 */
public class BOJ2331RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int A = toInt(in[0]), P = toInt(in[1]);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(A, 0);
        int count = 0;
        int next;
        int now = A;
        while (true) {
            count++;
            next = 0;
            int r;

            // now 의 각 자릿수를 구하여 제곱한 합을 구하기 위해 나머지 연산을 활용한다.
            while (now > 0) {
                r = now % 10;
                now = now / 10;
                next += Math.pow(r, P);
            }

            // 구한 다음 숫자가 map 에 저장되었다면, 이는 반복되는 수열이 등장했음을 뜻한다.
            // 따라서 이 다음 숫자가 등장한 순서가 몇번째인지를 출력한다.
            // 이는 앞에 몇 개의 반복되지 않는 수열이 있는지를 뜻하기도 하기 때문이다.
            if (map.containsKey(next)) {
                System.out.println(map.get(next));
                break;
            }

            // 구한 next 가 몇번째 순서로 등장했는지 저장한다.
            // now = next 를 통하여 다음 숫자를 기준으로 같은 과정을 반복한다.
            map.put(next, count);
            now = next;
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
