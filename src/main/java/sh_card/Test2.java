package sh_card;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

/**
 * created by victory_woo on 2020/09/09
 * 2번 문제.
 * 문자열 파싱과 정렬 문제.
 */
public class Test2 {
    public static void main(String[] args) {
        solution("012345", "20190620", new String[]{"price=80 code=987654 time=2019062113", "price=90 code=012345 time=2019062014", "price=120 code=987654 time=2019062010", "price=110 code=012345 time=2019062009", "price=95 code=012345 time=2019062111"});
    }

    private static void solution(String company_code, String day, String[] data) {
        ArrayList<Node> result = new ArrayList<>();
        for (String value : data) {
            String[] column = extractValue(value.split(" "));

            String price = column[0], code = column[1], time = column[2];
            if (matchCode(company_code, code) && matchDate(time, day)) {
                result.add(new Node(time, price));
            }
        }

        Collections.sort(result);

        for (Node node : result) System.out.println(node.price);
    }

    private static boolean matchCode(String companyCode, String code) {
        return companyCode.equals(code);
    }

    private static boolean matchDate(String time, String day) {
        return time.startsWith(day);
    }

    private static String[] extractValue(String[] column) {
        for (int i = 0; i < column.length; i++) {
            int index = column[i].indexOf('=');
            column[i] = column[i].substring(index + 1);
        }
        return column;
    }

    static class Node implements Comparable<Node> {
        int time;
        String price;

        public Node(String time, String price) {
            this.time = toInt(time);
            this.price = price;
        }

        @Override
        public int compareTo(@NotNull Node that) {
            return this.time - that.time;
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
