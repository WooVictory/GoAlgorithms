package programmers;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/08/16
 */
public class PGM42885 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }

    // 구명보트에 최대 2명만 태울 수 있다.
    public static int solution(int[] people, int limit) {
        // 오름차순으로 정렬한다.
        Arrays.sort(people);
        int start = 0;
        int answer = 0;

        // 몸무게가 가장 많이 나가는 사람과 가장 적게 나가는 사람을 태운다.
        // 반복문을 도는 시점에서 몸무게가 가장 많이 나가는 사람을 무조건 구명보트를 탈 수 있다.
        // 여기에 몸무게가 적게 나가는 사람이 같이 탈 수 있는지 없는지만 다를 뿐이다.
        for (int end = people.length - 1; end >= 0; end--) {
            if (end < start) break;

            // 몸무게가 가장 많이 나가는 사람과 가장 적게 나가는 사람을 태우고 limit 보다 작거나 같다면 둘 다 태운다.
            // start++ -> 다음으로 작은 사람을 가리키도록 한다.
            if (people[start] + people[end] <= limit) {
                start++;
                answer++;
            } else {
                // limit 보다 크다면 start 는 증가시키지 않는다. 즉, 작은 사람은 그대로 냅둔다.
                // 몸무게가 큰 사람만 태운다.
                answer++;
            }
        }

        // 구명보트의 갯수를 반환한다.
        return answer;
    }
}
