package data_structure.stack;

/**
 * created by victory_woo on 2020/10/10
 */
public class LinkedStack implements Stack {
    private StackNode top;
    private final String EMPTY = "Empty";

    LinkedStack() {
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(char item) {
        StackNode node = new StackNode(item);
        node.next = top;
        top = node;
    }

    @Override
    public char pop() {
        if (isEmpty()) {
            print(EMPTY);
            return 0;
        } else {
            StackNode node = top;
            top = node.next;
            return node.item;
        }
    }

    @Override
    public char peek() {
        if (isEmpty()) {
            print(EMPTY);
            return 0;
        } else {
            return top.item;
        }
    }

    @Override
    public void delete() {
        if (isEmpty()) print(EMPTY);
        else top = top.next;
    }

    private void print(String message) {
        System.out.println(message);
    }

    void printStack() {
        if (isEmpty()) {
            print(EMPTY);
        } else {
            StackNode node = top;
            print("<<Stack>>");
            while (node.next != null) {
                print(node.item + "");
                node = node.next;
            }
            print(node.item + "");
            print("");
        }
    }

    /*
    * 스택에서 찾고자 하는 데이터의 위치를 반환.
    * top 부터 찾고자 하는 데이터와 일치하는지 비교하여 일치하지 않는다면 다음 데이터로 비교한다.
    * top 이 위치 1을 반환하기 때문에 index 를 1로 초기화 하였고, 계속해서 다음 데이터와 비교할 때마다
    * index 를 증가시켜준다. 최종적으로 스택에서 데이터를 찾지 못한다면 -1을 반환한다.
    * */
    int searchIndex(char item) {
        int index = 1;
        StackNode tempTop = top;

        while (tempTop != null) {
            if (tempTop.item == item) return index;

            tempTop = tempTop.next;
            index++;
        }

        return -1;
    }
}
