package blind18;

import java.util.Arrays;

/**
 * created by victory_woo on 2020/09/11
 */
public class Test6 {
    public static void main(String[] args) {
        System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59",
                "23:59", "23:59", "23:59", "23:59", "23:59",
                "23:59", "23:59", "23:59", "23:59", "23:59",
                "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }

    // n : 셔틀 운행 횟수
    // t : 셔틀 운행 간격(분)
    // m : 셔틀 제한 인원
    private static String solution(int n, int t, int m, String[] timetable) {
        int len = timetable.length;

        // 1. 시간을 모두 분으로 변경한다.
        int[] minutes = getMinutes(timetable);
        // 2. 오름차순 정렬한다.
        Arrays.sort(minutes);

        // 대기열에 있는 크루들을 태웠음을 체크하기 위한 배열.
        boolean[] visit = new boolean[len];

        // 시작시간인 09:00의 분 표현.
        int hour = 540;
        int conTime = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < len; j++) {
                // 크루의 도착시각이 버스의 출발시각인 hour 보다 작거나 같고, 태운 적이 없다면
                // hour 시각에 출발하는 버스를 탈 수 있다.
                if (minutes[j] <= hour && !visit[j]) {
                    visit[j] = true;
                    count++;
                    // 크루가 버스에 탄 만큼 증가시켜준다. 즉, 버스에 탄 크루의 인원 수.
                }

                // 제한된 인원만큼 버스에 다 태운 경우.
                if (m <= count) {
                    // 그리고 이 버스가 마지막 버스라면 콘은 이 버스에 탄 마지막 크루보다 1분 더 일찍
                    // 도착하게 되면 버스에 타서 사무실에 늦게 도착할 수 있다.
                    if (i == n - 1) conTime = minutes[j] - 1;
                    break;
                }
            }

            // 운행 간격만큼 증가시켜준다.
            hour += t;
        }

        // 대기열에 있는 크루를 다 태워도 버스에 제한된 인원만큼 채워지지 않아 빈 좌석이 남아있을 수 있다.
        // 그렇다면 이때 콘은 가장 마지막 버스에 타면 되므로
        // 시작시간이 09:00부터 이기 때문에 n번을 돌더라도 실제 시간은 운행 횟수는 n-1번이 된다.
        // 따라서 아래와 같은 수식이 나오게 된다.
        // 시작시각 + (운행횟수)x운행 간격 시간.
        if (conTime == -1) {
            conTime = 540 + (n - 1) * t;
        }

        return convert(conTime);
    }

    private static String convert(int h) {
        int time = h / 60;
        int minute = h % 60;

        String t = time < 10 ? "0" + time : time + "";
        String m = minute < 10 ? "0" + minute : minute + "";

        return t + ":" + m;
    }

    private static int[] getMinutes(String[] timetable) {
        int[] result = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            result[i] = getMinute(timetable[i]);
        }
        return result;
    }

    private static int getMinute(String s) {
        String[] arr = s.split(":");
        return toInt(arr[0]) * 60 + toInt(arr[1]);
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
