package readyForKB.Hash;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/11/09
 */
public class Test2 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));

        System.out.println(solution(new String[]{"123", "456", "789"}));
    }

    /*
     * 접근 방법.
     * 2중 for 문으로 하나씩 확인하면서 순차 접근.
     * 하지만, 이렇게 되면 2개의 케이스에서 틀리는데
     * 이유는 이런 테스트 케이스가 존재할 수 있기 때문
     * phone_book = ["010111", "010"]
     * 따라서 정렬을 먼저 해줘야 짧은게 앞으로 오면서 제대로 된 비교가 가능.
     * */
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
}
