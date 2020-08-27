package programmers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * created by victory_woo on 2020/08/27
 */
public class PGM43164 {
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


    private static String[][] map;
    private static boolean[] visit;
    private static int len;
    private static String route = "";
    private static ArrayList<String> result;

    public static String[] solution(String[][] tickets) {
        len = tickets.length;
        map = tickets;
        visit = new boolean[len];
        result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            String departure = map[i][0], arrive = map[i][1];
            if (departure.equals("ICN")) {
                visit[i] = true;
                route = departure + ",";
                dfs(arrive, 1);
                visit[i] = false;
            }
        }
        Collections.sort(result);
        System.out.println(result);
        System.out.println(result.get(0));

        return result.get(0).split(",");
    }

    private static void dfs(String arrive, int count) {
        route += arrive + ",";
        if (count == len) {
            result.add(route);
            return;
        }

        for (int i = 0; i < len; i++) {
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
