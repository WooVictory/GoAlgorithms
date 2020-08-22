package programmers;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/08/23
 */
public class PGM17680 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        LinkedList<String> lruCache = new LinkedList<>();
        int answer = 0;

        // 대소문자 무시.
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        for (String city : cities) {
            if (lruCache.contains(city)) { // cache hit
                answer += 1;
                lruCache.remove(city);
                lruCache.addLast(city);
            } else {
                answer += 5;
                if (lruCache.size() == cacheSize) { // cache miss
                    lruCache.removeFirst();
                    lruCache.addLast(city);
                } else {
                    lruCache.addLast(city);
                }
            }
        }
        return answer;
    }
}
