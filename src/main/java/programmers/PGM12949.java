package programmers;

/**
 * created by victory_woo on 2020/08/18
 */
public class PGM12949 {
    public static void main(String[] args) {
        /*int[][] arr1 = {
                {1, 4},
                {3, 2},
                {4, 1}};
        int[][] arr2 = {
                {3, 3},
                {3, 3}};*/
        int[][] arr1 = {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}};
        int[][] arr2 = {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}};
        solution(arr1, arr2);
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];
        int row = arr1.length;
        int col = arr2[0].length;
        int l = arr1[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < l; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        // print
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }
}
