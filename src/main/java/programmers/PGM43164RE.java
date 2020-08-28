package programmers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * created by victory_woo on 2020/08/28
 */
public class PGM43164RE {
    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };
        solution(tickets);
    }

    private static String route = "";
    private static int N;
    private static boolean[] visit;
    private static String[][] map;

    public static String[] solution(String[][] tickets) {
        map = tickets;
        N = tickets.length;
        visit = new boolean[N];


        for (int i = 0; i < N; i++) {
            String departure = tickets[i][0], arrive = tickets[i][1];
            if (departure.equals("ICN")) {
                System.out.println(departure);
                visit[i] = true;
                route = departure + ",";
                dfs(arrive, 1);
                visit[i] = false;
            }
        }

        Collections.sort(result);
        System.out.println(result);
        return result.get(0).split(",");
    }

    private static ArrayList<String> result = new ArrayList<>();

    private static void dfs(String arrive, int count) {
        route += arrive + ",";

        if (count == N) {
            result.add(route);
            return;
        }


        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;

            String start = map[i][0], end = map[i][1];
            if (arrive.equals(start)) {
                visit[i] = true;
                dfs(end, count + 1);
                visit[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}
