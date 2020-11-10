package readyForKB.DFS_BFS;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/11/10
 */
public class Test3 {
    public static void main(String[] args) {
        /*System.out.println(solution("hit", "cog"
                , new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));*/
        System.out.println(solution("hit", "cog"
                , new String[]{"hot", "dot", "dog", "lot", "log"}));
    }


    /*
     * 접근 방법.
     * bfs 탐색을 이용해서 접근했다. 왜냐하면 단어를 변환하기 위한 최소 횟수를 구해야 하기 때문이다.
     * 먼저, words 배열이 target 을 포함하고 있지 않다면 변환할 수 없으므로 확인하고 0을 반환한다.
     *
     * 큐에 하나씩 넣고 빼면서 words 배열을 확인한다.
     * 이때, 큐에서 꺼낸 단어와 다른 글자가 1개만 존재하는지 확인하고 방문한 적이 없다면 큐에 넣는다.
     * 큐에 넣을 때, 이전 단어의 count+1만큼 넣어준다.
     * 그래야 단어 변환을 위해 거쳐온 단계를 저장할 수 있다.
     *
     * cur.word 가 target 과 같다면 cur.count 를 반환하며 종료한다.
     * */
    public static int solution(String begin, String target, String[] words) {
        int len = words.length;
        boolean[] visited = new boolean[len];
        boolean flag = false;
        for (String word : words) {
            if (target.equals(word)) flag = true;
        }

        if (!flag) return 0;

        LinkedList<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));

        while (!q.isEmpty()) {
            Word cur = q.remove();

            System.out.println(cur.word + ", " + cur.count);

            if (cur.word.equals(target)) return cur.count;

            for (int i = 0; i < len; i++) {
                String word = words[i];

                if (check(word, cur.word) && !visited[i]) {
                    visited[i] = true;
                    q.add(new Word(word, cur.count + 1));
                }
            }
        }

        return 0;
    }

    // 차이가 1개만 있어야 함.
    private static boolean check(String word, String cur) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            char b = cur.charAt(i);

            if (a != b) count++;
        }

        return count == 1;
    }

    static class Word {
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
