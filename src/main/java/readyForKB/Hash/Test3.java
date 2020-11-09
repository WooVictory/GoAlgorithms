package readyForKB.Hash;

import java.util.HashMap;

/**
 * created by victory_woo on 2020/11/09
 */
public class Test3 {
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution(clothes));
    }

    /*
     * 접근 방법.
     * HashMap 을 이용해서 의상의 종류를 Key 값으로 하고, 그 의상 종류의 갯수를 value 로 사용.
     * 위 예시의 경우, 아래와 같다.
     * headGear - 2개
     * eyeWear - 1개
     *
     * head 를 각각 1개씩 뽑을 수 있는 경우는 2개이며, head 를 뽑지 않는 경우도 있기 때문에 (2+1)
     * eye 도 마찬가지이다.
     * 그렇다면 둘을 곱하면 3x2 = 6이 나온다. 정답은 5인데, 왜 6이 나오는지 확인해보자.
     * [y, g, $]
     * [b, $]
     *
     * => yb, y, gb, g, b, $$에
     * 여기서 어떤 종류의 의상도 뽑지 않는 경우는 제외해야 한다. 왜냐하면 문제에서 최소 1개 이상의 옷을 입는다고 했기 때문!
     * 따라서 $$를 제거하면 5개로 정답이 된다.
     * * */
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        int answer = 1;
        for (int value : map.values()) answer = answer * (value + 1);
        return answer - 1;
    }
}
