package programmers;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/08/20
 */
public class PGM17677 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> list1 = convert(str1);
        ArrayList<String> list2 = convert(str2);

        if (list1.size() == 0 || list2.size() == 0) return 65536;

        return getJaccardSimilarity(list1, list2);
    }

    private static ArrayList<String> convert(String str) {
        StringBuilder sb;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            sb = new StringBuilder();
            char a = str.charAt(i);
            char b = str.charAt(i + 1);

            if (Character.isAlphabetic(a) && Character.isAlphabetic(b)) result.add(sb.append(a).append(b).toString());
        }
        return result;
    }

    private static int getJaccardSimilarity(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>(list1);


        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    String b = list2.remove(j);
                    intersection.add(b);
                    break;
                }
            }
        }

        union.addAll(list2);
        System.out.println(intersection);
        System.out.println(union);
        double value = (double) intersection.size() / union.size();
        return (int) (value * 65536);
    }
}
