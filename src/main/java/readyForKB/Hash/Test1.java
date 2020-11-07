package readyForKB.Hash;

import java.util.HashMap;

/**
 * created by victory_woo on 2020/11/07
 */
public class Test1 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));

        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    /*
     * 접근 방법.
     * 참가자를 Hash 에 넣는다.
     * Completion 을 돌면서 Hash 를 빼고, 1 이상인 거 뺌.
     * */
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);

        for (String c : completion) {
            if (map.containsKey(c)) {
                int value = map.get(c);
                value--;
                map.put(c, value);
            }
        }

        String answer = "";
        for (String key : map.keySet()) {
            if (1 <= map.get(key)) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
