package programmers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * created by victory_woo on 2020/08/17
 */
public class PGM64065 {
    public static void main(String[] args) {
        System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        System.out.println(solution("{{20,111},{111}}"));
    }

    private static HashMap<String, Integer> map;

    public static int[] solution(String s) {
        map = new HashMap<>();
        s = s.substring(1, s.length() - 1);
        int size = getSize(s);
        int start = 0, end;
        for (int i = 0; i < size; i++) {
            start = s.indexOf('{', start);
            end = s.indexOf('}', start);

            countTuple(s.substring(start + 1, end).split(","));

            start = end;
        }

        ArrayList<Tuple> list = new ArrayList<>();
        for (String key : map.keySet()) list.add(new Tuple(key, map.get(key)));
        Collections.sort(list);
        System.out.println(list);

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) result[i] = Integer.parseInt(list.get(i).number);

        for (int i : result) System.out.println(i);
        return result;
    }

    static class Tuple implements Comparable<Tuple> {
        String number;
        int count;

        Tuple(String number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Tuple that) {
            return that.count - this.count;
        }
    }

    private static int getSize(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '}') count++;
        }

        return count;
    }

    private static void countTuple(String[] s) {
        for (String value : s) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
    }
}
