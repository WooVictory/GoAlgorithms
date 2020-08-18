package programmers;

/**
 * created by victory_woo on 2020/08/18
 */
public class PGM12905 {
    public static void main(String[] args) {
        /*int[][] arr = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        };*/
        int[][] arr = {
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int row = arr.length, col = arr[0].length;
        int up, left, upLeft;
        int max = Integer.MIN_VALUE;

        if (row < 2 || col < 2) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (arr[i][j] == 1) {
                        return 1;
                    }
                }
            }
        }else{
            for (int i = 1; i < row; i++) {
                int min;
                for (int j = 1; j < col; j++) {
                    if (arr[i][j] == 1) {
                        up = arr[i - 1][j];
                        left = arr[i][j - 1];
                        upLeft = arr[i - 1][j - 1];

                        min = Math.min(up, Math.min(left, upLeft));
                        arr[i][j] = min + 1;

                        if (max < arr[i][j]) max = arr[i][j];
                    }
                }
            }
        }

        return max * max;
    }
}
