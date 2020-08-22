package programmers;

/**
 * created by victory_woo on 2020/08/21
 */
public class PGM17679 {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        //System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    private static char[][] map;
    private static int M, N;

    public static int solution(int m, int n, String[] board) {
        M = m;
        N = n;

        map = new char[M][N];

        // 1. 2차원 배열로 변환.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        int count = 0;
        int answer = 0;
        boolean[][] visit;

        do {
            // 2. 2차원 배열을 순회하면서 2x2 블록을 확인하며, 삭제할 블록들을 체크한다.
            visit = new boolean[M][N];
            count = 0;
            for (int r = 0; r < M - 1; r++) {
                for (int c = 0; c < N - 1; c++) {
                    if (map[r][c] == '0') continue;
                    checkBlock(r, c, map[r][c], visit);
                }
            }

            // 3. 블록을 지운다. 그리고 지운 블록의 개수를 증가시킨다.
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]) {
                        map[i][j] = '0';
                        count++;
                    }
                }
            }

            answer += count;
            dropBlock();

        } while (count != 0);

        return answer;
    }

    private static void checkBlock(int r, int c, char ch, boolean[][] visit) {
        for (int i = r; i <= r + 1; i++) {
            for (int j = c; j <= c + 1; j++) {
                if (map[i][j] != ch) return;
            }
        }

        // 삭제할 블록들을 체크해놓는다.
        for (int i = r; i <= r + 1; i++) {
            for (int j = c; j <= c + 1; j++) {
                visit[i][j] = true;
            }
        }
    }

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

}
