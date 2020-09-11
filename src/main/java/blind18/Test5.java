package blind18;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/09/11
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    private static int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> list1 = split(str1);
        ArrayList<String> list2 = split(str2);

        // 두글자씩 끊은 리스트의 사이즈가 모두 0이라면 교집합과 합집합을 구할 수 없으므로 65536을 반환한다.
        if (list1.size() == 0 && list2.size() == 0) return 65536;

        ArrayList<String> intersection = getIntersection(list1, list2);
        ArrayList<String> union = getUnion(list1, list2);

        // 교집합과 합집합의 사이즈가 같다면 1이 되고 이에 65536을 곱하니 65536을 반환하면 된다.
        if (intersection.size() == union.size()) return 65536;

        // 자카드 유사도를 계산하여 65536을 곱하여 결과를 반환한다.
        double result = (double) intersection.size() / union.size();

        return (int) (result * 65536);
    }

    // 문자열을 두글자씩 끊어서 리스트를 생성하여 반환한다.
    // 확인한 두 글자가 모두 알파벳이어야 가능하다. 그렇지 않다면 skip 한다.
    private static ArrayList<String> split(String s) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);

            if (!Character.isAlphabetic(a) || !Character.isAlphabetic(b)) continue;

            list.add(a + "" + b);
        }

        return list;
    }

    // deep copy
    // 교집합을 구한다.
    // list1 = [1,2,4,4,4], list2 = [4,4,5,8,7]
    // 교집합의 갯수는 2개가 나와야 한다.
    // 하지만, 처음에 나는 list2.remove(a)를 하지 않았다. 따라서 교집합의 갯수는 3개가 나왔다. [4,4,4]
    // 하지만, list1과 list2에서 공통으로 존재하는 4를 체크한 후, 이미 체크한 원소는 중복하여 체크하지 않기 위해 확인한 뒤에는 list2에서 해당
    // 원소를 삭제하여 준다. 따라서 list2.remove(a)가 추가되었다.
    // result 에 공통으로 존재하는 값을 담았기 때문에 교집합이 된다.
    private static ArrayList<String> getIntersection(ArrayList<String> list1, ArrayList<String> list2) {
        list1 = (ArrayList<String>) list1.clone();
        list2 = (ArrayList<String>) list2.clone();

        ArrayList<String> result = new ArrayList<>();

        for (String a : list1) {
            if (list2.contains(a)) {
                list2.remove(a);
                result.add(a);
            }
        }
        return result;
    }

    // deep copy
    // 합집합을 구한다.
    // list1과 list2에 공통으로 존재하는 원소를 list2에서 빼준다.
    // 그리고 result 에는 list1의 원소를 그대로 담아준다.
    // list2에는 list1과 공통된 원소가 빠진 원소들이 남아있다.
    // 그리고 result 에 list2를 addAll()하게 되면 합집합을 구할 수 있다.
    private static ArrayList<String> getUnion(ArrayList<String> list1, ArrayList<String> list2) {
        list1 = (ArrayList<String>) list1.clone();
        list2 = (ArrayList<String>) list2.clone();

        ArrayList<String> result = new ArrayList<>();

        for (String a : list1) {
            list2.remove(a);
            result.add(a);
        }
        result.addAll(list2);

        return result;
    }
}
