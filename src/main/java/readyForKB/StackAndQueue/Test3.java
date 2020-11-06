package readyForKB.StackAndQueue;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/11/06
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        // 1. 초기화 작업으로 list 에 모두 담아준다.
        LinkedList<Info> list = new LinkedList<>();
        int ascii = 65;
        for (int i = 0; i < priorities.length; i++) {
            list.add(new Info(i, priorities[i], (char) ascii));
            ascii++;
        }

        LinkedList<Info> result = new LinkedList<>();
        boolean flag;
        while (list.size() != 0) {
            flag = false;
            Info info = list.removeFirst();

            for (Info temp : list) {
                if (info.priority < temp.priority) {
                    flag = true;
                    break;
                }
            }

            if (flag) list.addLast(info);
            else result.add(info);

        }

        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            Info info = result.get(i);

            if (info.index == location) index = i;
        }

        return index + 1;
    }

    static class Info {
        int index;
        int priority;
        char alph;

        Info(int index, int priority, char alph) {
            this.index = index;
            this.priority = priority;
            this.alph = alph;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "index=" + index +
                    ", priority=" + priority +
                    ", alph=" + alph +
                    '}';
        }
    }
}
