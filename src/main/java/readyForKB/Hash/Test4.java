package readyForKB.Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * created by victory_woo on 2020/11/09
 */
public class Test4 {
    public static void main(String[] args) {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Genre> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            list.add(new Genre(genres[i], i, plays[i]));

        }

        // map - value 를 기준으로 내림 차순 정렬.
        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        Collections.sort(list);
        ArrayList<Integer> result = new ArrayList<>();
        for (String key : keySet) {
            int count = 0;
            for (Genre genre : list) {
                if (2 <= count) break;

                if (genre.genre.equals(key)) {
                    result.add(genre.index);
                    count++;
                }
            }
        }

        System.out.println(result);


        System.out.println(map);
        System.out.println(list);
        return result.stream().mapToInt(x -> x).toArray();
    }

    static class Genre implements Comparable<Genre> {
        String genre;
        int index;
        int play;

        Genre(String genre, int index, int play) {
            this.genre = genre;
            this.index = index;
            this.play = play;
        }

        @Override
        public String toString() {
            return "Genre{" +
                    "genre='" + genre + '\'' +
                    ", index=" + index +
                    ", play=" + play +
                    '}';
        }

        @Override
        public int compareTo(Genre that) {
            if (this.play == that.play) return this.index - that.index;
            return that.play - this.play;
        }
    }
}
