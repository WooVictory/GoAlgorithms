package data_structure.stack;

/**
 * created by victory_woo on 2020/10/10
 */
public class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.printStack();

        System.out.println("Index : " + stack.searchIndex('A'));
        System.out.println("Index : " + stack.searchIndex('C'));

        System.out.println("Pop : " + stack.pop());
        stack.printStack();

        System.out.println("Peek : " + stack.peek());
        stack.printStack();
    }
}
