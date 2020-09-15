package programmers;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * created by victory_woo on 2020/09/07
 */
public class PGM49191RE {
    public static void main(String[] args) {
        int[][] arr = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };
        System.out.println(solution(5, arr));
    }

    public static int solution(int n, int[][] results) {
        ArrayList<Player> players = new ArrayList<>();

        // 1. 플레이어 생성.
        for (int i = 0; i <= n; i++) players.add(new Player(i));

        // 2. 플레이어의 이기거나 진 관계를 나타낸다.
        for (int[] result : results) {
            // 어떤 상대를 이겼는지 추가한다.
            players.get(result[0]).winner.add(result[1]);
            // 어떤 상대한테 졌는지 추가한다.
            players.get(result[1]).loser.add(result[0]);
        }

        for (int i = 0; i < n; i++) {
            for (Player player : players) {
                HashSet<Integer> winnerSet = new HashSet<>();
                for (Integer w : player.winner) {
                    for (Integer win : players.get(w).winner) {
                        winnerSet.add(win);
                    }
                }
                player.winner.addAll(winnerSet);

                HashSet<Integer> loserSet = new HashSet<>();
                for (Integer l : player.loser) {
                    for (Integer lose : players.get(l).loser) {
                        loserSet.add(lose);
                    }
                }
                player.loser.addAll(loserSet);
            }

        }

        int count = 0;
        for (Player player : players) {
            int size = player.winner.size() + player.loser.size();

            if (size == n - 1) count++;
        }

        return count;
    }

    static class Player {
        int code;
        HashSet<Integer> winner = new HashSet<>();
        HashSet<Integer> loser = new HashSet<>();


        public Player(int code) {
            this.code = code;
        }
    }
}
