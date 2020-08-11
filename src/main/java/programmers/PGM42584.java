package programmers;

/**
 * created by victory_woo on 2020/08/11
 */
public class PGM42584 {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 2, 4});
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int value = prices[i];
            int count = 0;
            for (int j = i + i; j < prices.length; j++) {
                count++;
                if (prices[j] < value) break;
            }

            answer[i] = count;
        }
        return answer;
    }
}
