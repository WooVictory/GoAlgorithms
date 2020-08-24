package programmers;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/08/24
 */
public class PGM17684 {
    public static void main(String[] args) {
        solution("KAKAO");
        solution("TOBEORNOTTOBEORTOBEORNOT");
        solution("ABABABABABABABAB");
    }

    public static int[] solution(String msg) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int index = 65;
        while (index <= 90) {
            char c = (char) index;
            list.add(String.valueOf(c));
            index++;
        }

        String[] words = msg.split("");
        String now = words[0];
        String next = "";
        for (int i = 1; i < words.length; i++) {
            next = words[i];

            if (!list.contains(now + next)) {
                result.add(list.indexOf(now) + 1);
                list.add((now + next));
                now = next;
            } else {
                now = now + next;
            }
        }

        result.add(list.indexOf(now) + 1);

        System.out.println(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = result.get(i);
        return answer;
    }
}
