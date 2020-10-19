package data_structure.stack;

/**
 * created by victory_woo on 2020/10/09
 */
public class StackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        System.out.println(stack.pop());
        stack.push('A');
        stack.push('B');
        stack.push('C');

        stack.printStack();

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        stack.printStack();
        stack.push('D');
        stack.push('E');

        stack.printStack();

        stack.delete();
        stack.delete();
        stack.printStack();
    }
}
