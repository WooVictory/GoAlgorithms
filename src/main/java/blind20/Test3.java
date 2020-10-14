package blind20;

import java.util.HashMap;
import java.util.Map;

/**
 * created by victory_woo on 2020/09/11
 * 가사 검색.
 */
public class Test3 {
    public static void main(String[] args) {
        solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
    }

    // 와일드 카드 문자가 앞에서 나올 수도 있고, 뒤에서 나올 수도 있어서
    // 트라이 자료구조에 frodo, odorf 처럼 역순으로도 저장한다.
    private static int[] solution(String[] words, String[] queries) {
        Trie[] tries = new Trie[10001];

        // 단어의 길이에 해당하는 trie 값이 널이라면 객체를 생성한다.
        // 그리고 그 길이에 맞는 트라이 구조를 만들기 위해 word 를 삽입한다.
        for (String word : words) {
            int length = word.length();
            if (tries[length] == null) tries[length] = new Trie();
            tries[length].insert(word);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            int length = queries[i].length();
            if (tries[length] == null) result[i] = 0;
            else result[i] = tries[length].getCount(queries[i]);

            System.out.println(result[i]);
        }

        return result;
    }

    // front : 순서대로 저장
    // back : 역순으로 저장.
    static class Trie {
        Node front;
        Node back;

        Trie() {
            this.front = new Node();
            this.back = new Node();
        }

        void insert(String word) {
            insertFront(word);
            insertBack(word);
        }

        // ex : frodo
        // 해당 노드의 등장 횟수를 증가시킨다.
        // 현재 노드가 문자를 Key 로 하는 자식 노드를 가지고 있는지 조사한다.
        // 가지고 있다면 thisNode 는 그 해당 문자를 Key 로 하는 자식노드가 된다. 즉, 타고 내려가면서 thisNode를 바꾼다.
        // 문자를 Key 로 하는 자식 노드가 없다면 그 문자를 key 로 하는 노드를 생성하고
        // thisNode 는 해당 문자를 Key 로 하는 자식노드로 이어준다.
        private void insertFront(String word) {
            Node thisNode = this.front;
            for (int i = 0; i < word.length(); i++) {
                thisNode.increaseCount();
                //thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new word());
                if (thisNode.getChildNodes().containsKey(word.charAt(i))) {
                    thisNode = thisNode.getChildNodes().get(word.charAt(i));
                } else {
                    thisNode.getChildNodes().put(word.charAt(i), new Node());
                    thisNode = thisNode.getChildNodes().get(word.charAt(i));
                }
            }
        }

        // insertFront 의 반대 과정이다.
        private void insertBack(String word) {
            Node thisNode = this.back;
            for (int i = word.length() - 1; i >= 0; i--) {
                thisNode.increaseCount();
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new Node());
            }
        }

        // 와일드 카드 문자가 앞에 있으면 back 에서 카운트를 계산한다.
        // 와일드 카드 문자가 뒤에 있으면 front 에서 카운트를 계산한다.
        int getCount(String query) {
            if (query.charAt(0) == '?') return getCountFromBack(query);
            else return getCountFromFront(query);
        }

        // 와일드 카드 문자를 만나기 전까지 계속 진행한다.
        // 와일드 카드 문자에는 어느 알파벳이 와도 가능하기 때문에, 와일드 카드 이전까지
        // 쿼리의 문자와 일치하는 word 가 몇개인지 확인해야 한다.
        // 만약, 쿼리의 문자를 Key 로 하는 자식 노드가 없다면 0을 반환한다.
        // 있다면 연결된 자식 노드를 따라간다.
        // 그리고 최종으로 도달한 노드의 count 를 반환하면, 이값이 query 와 매칭되는
        // word 의 갯수가 된다.
        private int getCountFromFront(String query) {
            Node thisNode = this.front;
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) == '?') break;
                if (!thisNode.getChildNodes().containsKey(query.charAt(i))) return 0;
                thisNode = thisNode.getChildNodes().get(query.charAt(i));
            }

            return thisNode.count;
        }

        private int getCountFromBack(String query) {
            Node thisNode = this.back;
            for (int i = query.length() - 1; i >= 0; i--) {
                if (query.charAt(i) == '?') break;
                if (!thisNode.getChildNodes().containsKey(query.charAt(i))) return 0;
                thisNode = thisNode.getChildNodes().get(query.charAt(i));
            }
            return thisNode.count;
        }
    }

    // Trie 자료구조의 노드 역할을 한다.
    // '부모 노드'나 '현재 자신이 어떤 알파벳인지'를 나타내지 않으며
    // 단지 현재 알파벳을 Key 로 하는 자식 노드를 가지고 있다.
    static class Node {
        int count;
        Map<Character, Node> childNodes;

        Node() {
            count = 0;
            childNodes = new HashMap<>();
        }

        int getCount() {
            return this.count;
        }

        Map<Character, Node> getChildNodes() {
            return this.childNodes;
        }

        void increaseCount() {
            this.count++;
        }
    }
}