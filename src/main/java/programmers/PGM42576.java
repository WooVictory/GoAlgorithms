package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * created by victory_woo on 2020/08/06
 */
public class PGM42576 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) - 1);
            }
        }

        String answer = "";
        for (String key : map.keySet()) {
            if (map.get(key) > 0) answer = key;
        }
        return answer;
    }
}
