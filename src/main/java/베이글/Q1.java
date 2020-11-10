package 베이글;

/**
 * created by victory_woo on 2020/11/05
 * 사다리 타기 게임...? 어렵네.. ㅠ
 *
 */
public class Q1 {
    public static void main(String[] args) {
        int[][] ladder = {
                {1, 0, 1},
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0},
                {1, 0, 0}
        };
        solution(4, ladder);
    }

    private static int row, col;
    private static int[][] map;

    public static int[] solution(int n, int[][] ladder) {
        row = ladder.length;
        col = ladder[0].length;
        map = new int[row][col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = ladder[i][j];
            }

            map[i][col] = 0;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col + 1; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();

        }


        for (int i = 1; i < n; i++) {
            System.out.println(find(i));
        }


        int[] answer = {};
        return answer;
    }


    private static int find(int index) {
        int x = 0;
        int y = index - 1;

        while (x < row || y < col) {

            if (map[x][y] == 1) {
                x++;
                y++;
                continue;
            }

            if (map[x][y] == 0) {
                if (y - 1 < 0) x = 0;

                if (map[x][y - 1] == 1) {
                    x++;
                    y--;
                    continue;
                }

                //if (y + 1 >= col + 1) y = col - 1;

                if (y + 1 < col + 1) {
                    if (map[x][y + 1] == 1) {
                        x++;
                        y++;
                        continue;
                    }
                }

                x++;
            }
        }

        System.out.println(x + ", " + y);

        return 1;
    }

    /*private static int find(int index, int[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            if (ladder[i][index] == 1 || ladder[i][index] == 0) {
                if (ladder[i][index - 1] == 1 && ladder[i][index] == 0) {
                    index--;
                } else {
                    index++;
                }
            }
        }
        return index;
    }*/
}
