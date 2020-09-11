package blind18;

/**
 * created by victory_woo on 2020/09/11
 */
public class Test7 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}));

        System.out.println(solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"

        }));
    }

    public static int solution(String[] lines) {
        int length = lines.length;
        int[] startTimes = new int[length];
        int[] endTimes = new int[length];


        getTimes(lines, startTimes, endTimes);
        int answer = 0;

        // 시작점을 기준으로 윈도우를 만든다.
        for (int i = 0; i < length; i++) {

            int count = 0;
            int startPoint = startTimes[i];
            int startSection = startPoint + 1000;

            for (int j = i; j < length; j++) {
                if (startPoint <= startTimes[j] && startTimes[j] < startSection) {
                    // 다른 로그의 시작점이 윈도우에 걸치는 경우.
                    count++;
                } else if (startPoint <= endTimes[j] && endTimes[j] < startSection) {
                    // 다른 로그의 끝 점이 윈도우에 걸치는 경우.
                    count++;
                } else if (startTimes[j] <= startPoint && startSection <= endTimes[j]) {
                    // 다른 로그가 윈도우를 포함하는 경우.
                    count++;
                }
            }

            if (answer < count) answer = count;
        }

        // 끝 점을 기준으로 윈도우를 만드는 경우.
        for (int i = 0; i < length; i++) {
            int count = 0;
            int startPoint = endTimes[i];
            int section = startPoint + 1000;

            for (int j = i; j < length; j++) {
                if (startPoint <= startTimes[j] && startTimes[j] < section) {
                    // 다른 로그의 시작점이 윈도우에 걸치는 경우.
                    count++;
                } else if (startPoint <= endTimes[j] && endTimes[j] < section) {
                    // 다른 로그의 끝 점이 윈도우에 걸치는 경우.
                    count++;
                } else if (startTimes[j] <= startPoint && section <= endTimes[j]) {
                    // 다른 로그가 윈도우를 포함하는 경우.
                    count++;
                }
            }

            if (answer < count) answer = count;
        }
        return answer;
    }

    // 로그를 파싱하여 startTimes, endTimes 배열에 담는다.
    private static void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < lines.length; i++) {
            // 공백을 기준으로 잘라서 응답 시간과 처리 시간을 구한다.
            String[] times = lines[i].split(" ");

            // 응답 시간을 구하기 위한 배열.
            String[] response = times[1].split(":");

            // 처리 시간을 구한다.
            // s까지 잘라서 소수점으로 계산한 뒤, int 형변환을 한다.
            int endTime = 0, startTime, processTime;
            processTime = (int) (toDouble(times[2].substring(0, times[2].length() - 1)) * 1000);

            // response 배열을 응답 완료 시간을 구한다.
            // 밀리초 단위로 처리하기 위해 1000(ms)를 곱한다.
            endTime += toInt(response[0]) * 3600 * 1000;
            endTime += toInt(response[1]) * 60 * 1000;
            endTime += (int) (toDouble(response[2]) * 1000);

            // 시작 시간은 응답 완료 시간 - 처리 시간 + 1이다.
            // 시작과 끝을 포함하기 때문에 1을 더해준다.
            startTime = endTime - processTime + 1;
            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    private static double toDouble(String s) {
        return Double.parseDouble(s);
    }
}
