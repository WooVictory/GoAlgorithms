package readyForKB.StackAndQueue;

/**
 * created by victory_woo on 2020/11/06
 */
public class Test1 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        solution(prices);
    }

    /*
    * 접근 방법.
    * 프로그래머스 문제로, Stack/Queue 카테고리에 있지만 왜인지는 모르겠다.
    * 단순 구현 문제로 생각하여 접근했다.
    * 2중 for 문을 사용했으며, 앞에서부터 차례대로 기준이 되는 가격을 정하고
    * 가격이 상승했다는 가정과 함께 시간을 증가시킨다.
    * 뒤에 있는 가격과 비교해서 가격이 떨어졌다면, 내부에 있는 반복문을 빠져나온다.
    * result 배열에 second 를 담는다.
    * 주의할 점으로는 앞선 가격이 떨어졌다면, 뒤에는 더이상 볼 필요가 없다는 것이다. 왜냐하면
    * 가격이 떨어지지 않은 기간이 몇 초인지 구하는 것이 핵심이기 때문이다.
    * */
    public static int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int second = 0;

            for (int j = i + 1; j < prices.length; j++) {
                second++;

                // 앞선 가격보다 떨어지면 뒤에는 볼 필요가 없음.
                if (prices[j] < price) break;
            }

            result[i] = second;
        }

        for (int r : result) System.out.println(r);
        return result;
    }
}
