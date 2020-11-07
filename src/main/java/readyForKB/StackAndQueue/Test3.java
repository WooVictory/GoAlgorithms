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

    /*
     * 접근방법.
     * Info 클래스 타입의 list 를 통해서 index, priority, alphabet 을 담은 list 를 생성한다.
     *
     * list 에 있는 인쇄물을 하나씩 꺼낸다.
     * 그리고 그 뒤에 있는 인쇄물들과 비교하여 우선순위가 더 높은 인쇄물이 있는지 찾는다.
     * 있다면 flag=true 로 변경한 뒤, 해당 반복문을 빠져나온다.
     * 우선순위가 더 높은 인쇄물이 있기 때문에 지금 확인하고 있는 인쇄물은 list 의 뒤로 넣어준다.
     * 만약, 지금 확인하고 있는 인쇄물보다 우선순위가 높은 인쇄물이 없다면 result 에 해당 인쇄물을 넣어준다.
     *
     * 이제, result 에 실제로 출력할 순서대로 인쇄물들이 담겨있다.
     * location 을 통해서 result 에 있는 원소들의 index == location 을 찾아서 index + 1을 반환한다.
     *
     * 이전에 풀었던 풀이와 비교해보기!
     * */
    public static int solution(int[] priorities, int location) {
        LinkedList<Info> q = new LinkedList<>();
        int ascii = 65;
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Info(i, priorities[i], (char) ascii));
            ascii++;
        }

        LinkedList<Info> result = new LinkedList<>();
        boolean flag;
        while (q.size() != 0) {
            flag = false;
            Info info = q.removeFirst();

            for (Info temp : q) {
                if (info.priority < temp.priority) {
                    flag = true;
                    break;
                }
            }

            if (flag) q.addLast(info);
            else result.add(info);
        }

        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).index == location) index = i;
        }

        return index + 1;
    }

    static class Info {
        int index;
        int priority;
        char alphabet;

        Info(int index, int priority, char alph) {
            this.index = index;
            this.priority = priority;
            this.alphabet = alph;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "index=" + index +
                    ", priority=" + priority +
                    ", alphabet=" + alphabet +
                    '}';
        }
    }
}
