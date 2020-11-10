package readyForKB.Hash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * created by victory_woo on 2020/11/09
 */
public class Test44 {
    public static void main(String[] args) {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    /*
     * 접근 방법.
     * HashMap - <Genre, 재생 횟수> 를 저장한다.
     * Song - 클래스 타입의 리스트를 통해 인덱스(고유 번호), 재생 횟수, 장르를 관리한다.
     *
     * map 을 value 기준으로 내림 차순 정렬을 한 keySet 을 구한다.
     * keySet 이 내림차순 정렬이 되어 있기 때문에 key 를 하나씩 꺼내서
     * list 에서 key 와 일치하는 원소를 꺼내서 result 에 index 를 담는다.
     * 이때, 2개까지만 담아야 하므로 count 변수를 통해서 제어한다.
     * result -> int[] arr 로 변환하여 반환한다.
     * */
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Song> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            list.add(new Song(i, plays[i], genres[i]));
        }

        // map 에서 key 를 꺼내서 value 를 내림차순 정렬.
        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));

        ArrayList<Integer> result = new ArrayList<>();
        for (String key : keySet) {
            int count = 0;
            for (Song song : list) {
                if (2 <= count) break;

                if (song.isMatch(key)) {
                    count++;
                    result.add(song.index);
                }
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    static class Song {
        int index;
        int plays;
        String genre;

        Song(int index, int plays, String genre) {
            this.index = index;
            this.plays = plays;
            this.genre = genre;
        }

        boolean isMatch(String s) {
            return this.genre.equals(s);
        }
    }

}
