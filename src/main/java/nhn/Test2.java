package nhn;

/**
 * created by victory_woo on 2020/10/24
 */
public class Test2 {
    public static void main(String[] args) {
        int[][] arr = {
                {6, 2, 11, 0, 3, 5},
                {6, 3, 0, 9, 0, 5},
        };

        solution(2, 6, arr);
    }

    private static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        //int[][] sum = new int[day][width];
        int max = Integer.MIN_VALUE;

        int[] sum = new int[width];

        int total = 0;
        int maxIndex = 0;

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                sum[j] += blocks[i][j];
                if (max < sum[j]) {
                    max = sum[j];
                    maxIndex = j;
                }

                /*else {
                    int value = max - sum[j];
                    sum[j] += value;
                    total += value;
                }

                System.out.print(sum[j] + " ");*/
            }

            for (int j=0;j<maxIndex;j++){

            }

            System.out.println();
        }
        System.out.println(total);

    }
}
