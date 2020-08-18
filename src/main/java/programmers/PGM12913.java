package programmers;

/**
 * created by victory_woo on 2020/08/18
 */
public class PGM12913 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        System.out.println(solution(arr));
    }

    // 두번째 행부터 시작하면 이전 행의 열의 값을 더하면서 최댓값이 되는 경우를 다음 행에 저장한다.
    public static int solution(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i][0] += max(arr[i - 1][1], arr[i - 1][2], arr[i - 1][3]);
            arr[i][1] += max(arr[i - 1][0], arr[i - 1][2], arr[i - 1][3]);
            arr[i][2] += max(arr[i - 1][0], arr[i - 1][1], arr[i - 1][3]);
            arr[i][3] += max(arr[i - 1][0], arr[i - 1][1], arr[i - 1][2]);
        }

        int n = arr.length - 1;
        int max = arr[n][0];
        for (int i = 1; i < 4; i++) {
            if (max < arr[n][i]) max = arr[n][i];
        }
        return max;
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}