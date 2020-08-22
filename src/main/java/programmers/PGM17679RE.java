package programmers;

/**
 * created by victory_woo on 2020/08/22
 */
public class PGM17679RE {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        //System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    private static int M, N;
    private static char[][] map;

    public static int solution(int m, int n, String[] board) {
        M = m;
        N = n;

        map = new char[M][N];

        // 1차원 배열 -> 2차원 배열 변환.
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        print();

        int count;
        int answer = 0;
        boolean[][] visit;

        do {
            count = 0;
            visit = new boolean[M][N];
            for (int r = 0; r < M - 1; r++) {
                for (int c = 0; c < N - 1; c++) {

                    // 블록이 없는 곳을 '0'으로 표시했지만, 2x2 영역에 지워진 블록으로 이루어져 있다면
                    // 체크할 수 있기 때문에 '0'을 만나면 건너뛴다.
                    if (map[r][c] == '0') continue;

                    // 지울 블록들만 체크한다.
                    checkArea(r, c, map[r][c], visit);
                }
            }
            // 체크해놨던 블록들을 지운다.
            // true 였던 곳들이 지워질 블록들이며, 블록을 지운 후 '0'을 놓는다.
            // 지워진 블록의 갯수만큼 count 한다.
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]) {
                        map[i][j] = '0';
                        count++;
                    }
                }
            }

            // 지운 블록의 갯수를 누적한다.
            answer += count;

            // 블록을 빈 자리로 아래로 떨어트린다.
            dropBlock();
            print();
        } while (count != 0);
        return answer;
    }

    // 블록에서 2x2 범위를 확인한다.
    // 모두 동일한 블록으로 구성되어 있으면, 블록을 지울 수 있다는 것을 체크한다.
    private static void checkArea(int row, int col, char ch, boolean[][] visit) {
        // 하나라도 다르다면, return.
        for (int r = row; r <= row + 1; r++) {
            for (int c = col; c <= col + 1; c++) {
                if (map[r][c] != ch) return;
            }
        }

        // 2x2 범위의 블록들이 모두 동일하다면, 지울 수 있으므로 체크해준다.
        for (int r = row; r <= row + 1; r++) {
            for (int c = col; c <= col + 1; c++) {
                visit[r][c] = true;
            }
        }
    }

    // 열마다 돌면서 확인한다.
    // 가장 하단부터 시작하며, 먼저 빈 공간을 찾는다.
    // 빈 공간을 찾으면, 그 위에서부터 블록이 있는 공간을 찾는다.
    // 찾으면 블록을 빈 공간에 놓고, 블록이 있던 자리를 '0'으로 만들어주면서 해당 반복문을 빠져나온다.
    // 그리고 해당 열의 위로 올라가면서 같은 경우가 있는지 확인하고 있다면 위의 과정을 반복한다.
    // 없다면 그대로 반복문을 끝까지 수행하다가 종료한다.
    private static void dropBlock() {
        for (int c = 0; c < N; c++) {
            for (int r = M - 1; r >= 0; r--) {
                if (map[r][c] == '0') {
                    for (int nr = r - 1; nr >= 0; nr--) {
                        if (map[nr][c] != '0') {
                            map[r][c] = map[nr][c];
                            map[nr][c] = '0';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
