package winter;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/10/31
 */
public class Q2 {
    public static void main(String[] args) {
        //System.out.println(solution("hellopython", "abcdefghijk", 3));
        // igoptvfbqyy actual
        // igoptvfbqyy expected
        System.out.println(solution("qyyigoptvfb", "abcdefghijk", 3));
        //System.out.println(solution("hellopython", "abcdefghijk", -3));
        //System.out.println(solution("qyyigoptvfb", "abcdefghijk", 3));
    }

    public static String solution(String encrypted_text, String key, int rotation) {
        ArrayList<Integer> list = new ArrayList<>();
        for (char k : key.toCharArray()) list.add(k - 'a' + 1);

        StringBuilder sb = new StringBuilder();
        int index;
        for (int i = 0; i < encrypted_text.length(); i++) {
            int value = (int) encrypted_text.charAt(i) + list.get(i);

            if ('z' < value) index = (value - 123) % 26;
            else index = (value - 97) % 26;

            sb.append((char) ('a' + index));
        }

        System.out.println(sb.toString());

        return rotate(sb.toString(), rotation);
    }

    private static String rotate(String word, int rotation) {
        int size = word.length();
        String[] result = new String[size];

        StringBuilder sb = new StringBuilder();
        if (0 <= rotation) {
            for (int i = 0; i < word.length(); i++) {
                int value = (i + rotation) % size;

                result[value] = String.valueOf(word.charAt(i));
            }

            for (String s : result) sb.append(s);
        } else {
            for (int i = 0; i < word.length(); i++) {
                int value = (i + rotation);
                if (value < 0) value = size + value + 1;

                value = value % size;

                result[value] = String.valueOf(word.charAt(i));
            }
            for (String s : result) sb.append(s);
        }

        return sb.toString();
    }

    // actual   : qyyigoptvfb
    // expected : qyyigoptvfb

    /*private static String rotate(String s, int rotation) {
        int count = 0;
        int start = 0;
        String[] arr = s.split("");
        while (count < arr.length) {
            int current = start;
            String cache = arr[current];

            do {
                int next = (current + rotation) % arr.length;
                String temp = arr[next];
                arr[next] = cache;
                cache = temp;
                current = next;
                count++;
            } while (start != count);
            start++;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : arr) sb.append(word);

        return sb.toString();
    }*/
}
