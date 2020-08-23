package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * created by victory_woo on 2020/08/23
 */
public class PGM17683 {
    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));

    }

    private static String[] sharp = {"C#", "D#", "F#", "G#", "A#"};
    private static String[] converted = {"c", "d", "f", "g", "a"};

    public static String solution(String m, String[] musicinfos) {
        if (m.contains("#")) m = convert(m);

        List<Music> list = new ArrayList<>();
        int index = 0;
        for (String music : musicinfos) {
            String[] info = music.split(",");
            int startTime = getMinuteFromString(info[0]);
            int endTime = getMinuteFromString(info[1]);
            int playTime = endTime - startTime;
            list.add(new Music(index++, playTime, info[2], getPlayOrder(convert(info[3]), playTime)));
        }


        List<Music> result = new ArrayList<>();
        for (Music music : list) {
            String play = music.playOrder;
            if (play.contains(m)) {
                result.add(music);
            }
        }

        if (result.isEmpty()) {
            return "(None)";
        } else {
            result.sort((o1, o2) -> {
                if (o1.playTime == o2.playTime) return o1.index - o2.index;
                return o2.playTime - o1.playTime;
            });
            return result.get(0).title;
        }
    }


    private static String convert(String s) {
        for (int i = 0; i < sharp.length; i++) {
            s = s.replaceAll(sharp[i], converted[i]);
        }
        return s;
    }

    private static int getMinuteFromString(String t) {
        String[] s = t.split(":");
        int hour = Integer.parseInt(s[0]) * 60;
        int minute = Integer.parseInt(s[1]);
        return hour + minute;
    }

    private static String getPlayOrder(String s, int playTime) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < playTime; i++) sb.append(s.charAt(i % len));
        return sb.toString();
    }

    static class Music {
        int index;
        int playTime;
        String title;
        String playOrder;

        Music(int index, int playTime, String title, String playOrder) {
            this.index = index;
            this.playTime = playTime;
            this.title = title;
            this.playOrder = playOrder;
        }

        @Override
        public String toString() {
            return "Music{" +
                    "index=" + index +
                    ", playTime=" + playTime +
                    ", title='" + title + '\'' +
                    ", playOrder='" + playOrder + '\'' +
                    '}';
        }
    }
}
