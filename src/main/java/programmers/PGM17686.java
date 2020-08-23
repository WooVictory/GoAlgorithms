package programmers;

import java.util.ArrayList;

/**
 * created by victory_woo on 2020/08/23
 */
public class PGM17686 {
    public static void main(String[] args) {
        //solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
        solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
    }

    public static String[] solution(String[] files) {
        ArrayList<File> list = new ArrayList<>();
        int index = 0;
        for (String file : files) {
            String[] s = getHeadFromFile(file.toLowerCase());
            list.add(new File(index++, file, s[0], Integer.parseInt(s[1]), s[2]));
        }

        list.sort((o1, o2) -> {
            if (o1.head.equals(o2.head)) {
                if (o1.number == o2.number) {
                    return o1.index - o2.index;
                } else {
                    return o1.number - o2.number;
                }
            } else {
                return o1.head.compareTo(o2.head);
            }
        });

        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) result[i] = list.get(i).origin;

        System.out.println(list);

        return result;
    }

    private static String[] getHeadFromFile(String file) {
        String[] result = new String[3];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                index = i;
                break;
            }
            sb.append(file.charAt(i));
        }

        result[0] = sb.toString();

        sb = new StringBuilder();
        for (int i = index; i < file.length(); i++) {
            if (!Character.isDigit(file.charAt(i))) {
                index = i;
                break;
            }
            sb.append(file.charAt(i));
        }

        result[1] = sb.toString();
        result[2] = file.substring(index);

        return result;
    }

    static class File {
        int index;
        String origin;
        String head;
        int number;
        String tail;

        File(int index, String origin, String head, int number, String tail) {
            this.index = index;
            this.origin = origin;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return "File{" +
                    "origin='" + origin + '\'' +
                    '}';
        }
    }
}
