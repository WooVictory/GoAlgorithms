package programmers;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * created by victory_woo on 2020/08/28
 */
public class PGM49191 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<Player> players = new ArrayList<>();

        // N 갯수만큼 플레이어 생성.
        for (int i = 0; i <= n; i++) {
            players.add(new Player(i));
        }

        for (int[] result : results) {
            // 이긴 기록을 보관한다. 즉, 누굴 이겼는지 추가한다.
            players.get(result[0]).win.add(result[1]);

            // 진 기록을 보관한다. 즉, 누구한테 졌는지 추가한다.
            players.get(result[1]).lose.add(result[0]);
        }


        for (Player p : players) {
            System.out.println(p);
        }


        for (int depth = 0; depth < n; depth++) {
            for (int i = 1; i <= n; i++) {
                // 현재 플레이어를 기준으로 확인한다.
                Player player = players.get(i);

                // 현재 플레이어가 이긴 플레이어라면 그 플레이어가 이긴 사람들도 모두 이길 수 있다.
                // 현재 플레이어가 상대 플레이어를 이겼다면, 상대 플레이어가 이긴 사람들도 현재 플레이어가 이길 수 있다.
                HashSet<Integer> winnerSet = new HashSet<>();
                for (Integer win : player.win) {
                    for (Integer w : players.get(win).win) {
                        winnerSet.add(w);
                    }
                }

                player.win.addAll(winnerSet); // 추가.

                // 현재 플레이거가 상대 플레이어한테 졌다면, 상대 플레이어한테 졌던 사람들한테도 현재 플레이어가 진다.
                HashSet<Integer> loserSet = new HashSet<>();
                for (Integer lose : player.lose) {
                    for (Integer l : players.get(lose).lose) {
                        loserSet.add(l);
                    }
                }

                player.lose.addAll(loserSet);

                System.out.println(player.win);
                System.out.println(player.lose);
                System.out.println();
            }
        }

        for (Player player : players) {
            int size = player.win.size() + player.lose.size();

            if (size == n-1) answer++;
        }

        return answer;
    }

    static class Player {
        int code;
        HashSet<Integer> win = new HashSet<>();
        HashSet<Integer> lose = new HashSet<>();

        Player(int code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "win=" + win +
                    ", lose=" + lose +
                    '}';
        }
    }
}
