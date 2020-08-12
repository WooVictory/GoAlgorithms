package programmers;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/08/12
 */
public class PGM42577 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            String value = phone_book[i];
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
