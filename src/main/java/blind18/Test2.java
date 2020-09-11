package blind18;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/09/10
 * 캐시.
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }

    private static int solution(int cacheSize, String[] cities) {
        // 캐시 사이즈가 0이라면 캐시가 되지 않으므로 모두 cache miss 이므로 각 도시마다 실행시간은 5가 걸린다.
        if (cacheSize == 0) return cities.length * 5;

        LinkedList<String> lru = new LinkedList<>();

        // 대소문자를 무시한다.
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        int time = 0;
        for (String city : cities) {
            // cache hit.
            // 실행시간을 1 더해준다.
            // 해당 도시를 lru 캐시에서 삭제한다.
            // 등장한 도시를 lru 캐시의 최근(마지막) 부분에 삽입한다.
            if (lru.contains(city)) {
                time += 1;
                lru.remove(city);
                lru.addLast(city);
            } else {
                // cache miss.
                // 실행시간을 5 더해준다.
                time += 5;

                // lru 의 사이즈가 꽉 찼다면 가장 오래 전에 참조되었던 원소를 삭제한다.
                // 그게 queue 의 가장 첫번째 원소가 된다.
                if (lru.size() == cacheSize) lru.removeFirst();

                // 그리고 가장 최근에 참조된 원소인 city 를 lru 캐시의 마지막 부분에 삽입한다.
                lru.addLast(city);
            }
        }

        return time;
    }
}