package nhn;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/10/24
 */
public class Test1 {
    public static void main(String[] args) {

        //solution(6, 2, new char[]{'B', 'C'}, 2, new int[]{3, -2});
        solution(17, 5, new char[]{'B', 'D', 'I', 'M', 'P'}, 11, new int[]{3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23});
    }

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        ArrayList<Player> list = new ArrayList<>();
        ArrayList<Player> quickPlayers = new ArrayList<>();

        // 빠른 사람들을 넣는다. 얘네는 술래가 되지 않음.
        for (char player : namesOfQuickPlayers) {
            quickPlayers.add(new Player(player, 0));
        }

        // 선수들 세팅.
        int start = 65;
        list.add(new Player((char) start++, 1));
        for (int i = 1; i <= numOfAllPlayers; i++) {
            list.add(new Player((char) start++, 0));
        }


        int position = 1;
        for (int i = 0; i < numOfGames; i++) {
            int tern = numOfMovesPerGame[i];
            position = position + tern;

            Player tagger = list.get(position); // 다음 술래를 정한다.
            boolean flag = false;

            for (char player : namesOfQuickPlayers) {
                if (player == tagger.name) flag = true;
            }

            // 빠른 사람이 아니므로 술래를 해야함.
            if (!flag) tagger.count++;

        }

        for (Player p : list) {
            System.out.println(p);
        }


    }

    static class Player {
        char name;
        int count;

        public Player(char name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name=" + name +
                    ", count=" + count +
                    '}';
        }
    }
}
