package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by victory_woo on 2020/08/26
 */
public class BOJ2331DFS {
    private static long[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int a = toInt(in[0]);
        int p = toInt(in[1]);

        // 몇번째 순서로 나타나는지 저장하기 위한 배열.
        check = new long[50000];

        System.out.println(dfs(a, p, 1));;
    }

    private static Long dfs(int a, int p, int count) {
        // 이미 나타난 적이 있다면
        // 나타난 순서에서 1을 빼주면, 반복되지 않은 수열의 갯수가 된다.
        // 1부터 시작했기 때문!1
        if (check[a] != 0) {
            return check[a] - 1;
        }

        // 해당 숫자가 몇번째로 나타났는지 저장한다.
        check[a] = count;
        // 다음 숫자를 구한다.
        int b = next(a, p);

        // 다음 숫자를 이용하여 dfs()를 호출하며, 순서는 1 증가한다.
        return dfs(b, p, count + 1);
    }

    // 이전 수에서 각 자릿수의 p 제곱의 합으로 다음 숫자를 구하여 반환한다.
    private static int next(int a, int p) {
        int answer = 0;
        int r;
        while (a != 0) {
            r = a % 10;
            a = a / 10;
            answer += Math.pow(r, p);
        }

        return answer;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
