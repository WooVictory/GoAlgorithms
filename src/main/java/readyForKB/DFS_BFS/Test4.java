package readyForKB.DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;

/**
 * created by victory_woo on 2020/11/10
 */
public class Test4 {
    public static void main(String[] args) {
        /*solution(new String[][]{
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        });*/

        solution(new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        });
    }

    /*
     * 첫번째 접근 방법.
     * bfs -> 알파벳으로 가까운 걸 찾아야 하기 때문에 백트래킹을 이용해서 다른 경우까지 모든 경우를
     * 탐색해야 함. 따라서 bfs 는 적절한 방법이 아님.
     * */
    /*private static boolean[] visited;
    private static StringBuilder sb;

    public static String[] solution(String[][] tickets) {
        int len = tickets.length;

        for (int i = 0; i < tickets.length; i++) {
            visited = new boolean[len];
            if (tickets[i][0].equals("ICN")) {
                sb = new StringBuilder("ICN").append('-');
                visited[i] = true;
                bfs(tickets[i][1], tickets);
            }
        }
        return null;
    }

    private static void bfs(String arrival, String[][] tickets) {
        LinkedList<String> q = new LinkedList<>();
        q.add(arrival);

        String cur = "";
        while (!q.isEmpty()) {
            cur = q.remove();
            System.out.println(cur);

            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && tickets[i][0].equals(cur)) {
                    visited[i] = true;
                    q.add(tickets[i][1]);
                    sb.append(tickets[i][1]).append('-');
                }
            }

        }

        System.out.println(sb.toString());
    }*/

    private static boolean[] visited;
    private static int n;
    private static ArrayList<String> result;
    private static String route;

    public static String[] solution(String[][] tickets) {
        n = tickets.length;
        visited = new boolean[n];
        result = new ArrayList<>();

        // 여기서도 처음에 시작한 경로가 최적의 답이 아닐 수 있기 때문에
        // 탐색이 끝나고 나서는 방문 여부 체크를 해제해준다.
        for (int i = 0; i < n; i++) {
            String departure = tickets[i][0], arrival = tickets[i][1];
            if (departure.equals("ICN")) {
                visited[i] = true;
                route = departure + ",";
                dfs(tickets, arrival, 1);
                visited[i] = false;
            }
        }

        Collections.sort(result);

        return result.get(0).split(",");
    }

    /*
     * 백트래킹을 통해서 만들 수 있는 모든 경로를 다 만들어 본다.
     * 티켓을 사용해서 모든 경로를 만들었다면 result 배열에 경로를 추가한다.
     *
     * arrival 과 방문하지 않은 티켓의 출발지와 같다면 탐색을 진행할 수 있다.
     * 방문 여부를 체크하고 dfs 를 호출하여 end 를 붙여나가면서 경로를 만든다.
     * 다음으로는 백트래킹을 수행한다. 방문했던 지점을 방문 여부를 해제하고, route 에서도
     * 해당 경로를 제거해준다.
     * */
    private static void dfs(String[][] tickets, String arrival, int count) {
        route = route + arrival + ",";

        // 티켓을 모두 사용한 경우, 경로를 다 탐색했으므로 만든 경로를 result 에 추가해준다.
        if (count == tickets.length) {
            result.add(route);
            return;
        }

        for (int i = 0; i < n; i++) {
            String start = tickets[i][0], end = tickets[i][1];
            if (!visited[i] && arrival.equals(start)) {
                visited[i] = true;
                dfs(tickets, end, count + 1);
                visited[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}
