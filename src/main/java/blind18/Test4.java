package blind18;

/**
 * created by victory_woo on 2020/09/11
 */
public class Test4 {
    public static void main(String[] args) {
        //System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    private static char[][] map;
    private static boolean[][] visit;

    private static int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        int answer = 0;
        int count;
        do {
            printMap(m, n);
            visit = new boolean[m][n];
            count = 0;

            // 2x2 box 검사.
            for (int i = 0; i <= m - 2; i++) {
                for (int j = 0; j <= n - 2; j++) {
                    // 지운 블록들이 2x2로 4칸을 차지하더라도 영향이 없어야 하므로 건너뛴다.
                    if (map[i][j] == '.') continue;

                    check(i, j, map[i][j]);
                }
            }

            // 체크해놓은 블록들을 지운다.
            // 블록을 지우고 '.'로 표시한다.
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i][j]) {
                        count++;
                        map[i][j] = '.';
                    }
                }
            }

            // 지운 블록의 갯수를 더해준다.
            answer += count;

            // 블록을 떨어트린다.
            dropBlock(m, n);
            printMap(m, n);
        } while (count != 0);

        return answer;
    }

    // 2x2 box 를 검사하며 ch 와 다르다면 return 한다.
    // 2x2 box 내의 블록이 ch 와 모두 같다면 visit 배열을 체크한다.
    private static void check(int r, int c, char ch) {
        for (int row = r; row <= r + 1; row++) {
            for (int col = c; col <= c + 1; col++) {
                if (map[row][col] != ch) return;
            }
        }

        for (int row = r; row <= r + 1; row++) {
            for (int col = c; col <= c + 1; col++) {
                visit[row][col] = true;
            }
        }
    }

    // 블록을 떨어트린다.
    // 빈 공간을 찾고 블록을 찾아서 블록을 빈 공간에 넣어주고, 블록이 있던 자리를 비워준다.
    private static void dropBlock(int m, int n) {
        for (int c = 0; c < n; c++) {
            for (int r = m - 1; r >= 0; r--) {
                if (map[r][c] == '.') {
                    for (int nr = r - 1; nr >= 0; nr--) {
                        if (map[nr][c] != '.') {
                            map[r][c] = map[nr][c];
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void printMap(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
