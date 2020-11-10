package readyForKB.DFS_BFS;

/**
 * created by victory_woo on 2020/11/10
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /*
    * 접근 방법.
    * 재귀 호출을 이용해서 타겟 넘버를 찾는다.
    * 더하는 경우, 빼는 경우 모두 재귀 호출을 통해서 index 가 끝까지 도달했을 때
    * sum 이 target 과 일치한다면 count 를 증가시켜준다.
    * */
    private static int count;

    public static int solution(int[] numbers, int target) {
        count = 0;
        solve(0, 0, target, numbers);
        return count;
    }

    private static void solve(int index, int sum, int target, int[] numbers) {
        if (index == numbers.length) {
            if (target == sum) count++;
            return;
        }

        solve(index + 1, sum + numbers[index], target, numbers);
        solve(index + 1, sum - numbers[index], target, numbers);
    }
}