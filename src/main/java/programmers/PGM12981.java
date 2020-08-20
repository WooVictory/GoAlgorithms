package programmers;

import java.util.HashSet;

/**
 * created by victory_woo on 2020/08/20
 */
public class PGM12981 {
    public static void main(String[] args) {
        solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
        solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
    }

    public static int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int order = 1;
        int people = 1;
        boolean flag = true;

        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            people = (i % n) + 1;
            if (i % n == 0) {
                order++;
            }

            // 앞 사람이 말한 단어의 마지막 글자와 현재 사람이 말한 단어의 앞 글자가 일치하는지 확인한다.
            char beforeLastChar = words[i - 1].charAt(words[i - 1].length() - 1);
            char currentFirstChar = words[i].charAt(0);

            if (beforeLastChar != currentFirstChar) {
                flag = false;
                break;
            }

            if (set.contains(word)) {
                flag = false;
                break;
            }

            set.add(word);
        }

        if (flag) System.out.println(0 + ", " + 0);
        else System.out.println(people + ", " + order);

        if (flag) return new int[]{0, 0};
        else return new int[]{people, order};
    }
}
