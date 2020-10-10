package data_structure.stack;

/**
 * created by victory_woo on 2020/10/09
 */
public class ArrayStack implements Stack {
    private int top;
    private int size;
    private char[] itemArray;
    private final String FULL_MESSAGE = "Stack is Full";
    private final String EMPTY_MESSAGE = "Stack is Empty";

    ArrayStack(int size) {
        this.top = -1;
        this.size = size;
        this.itemArray = new char[this.size];
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    private boolean isFull() {
        return (top == size - 1);
    }

    @Override
    public void push(char item) {
        if (isFull()) print(FULL_MESSAGE);
        else itemArray[++top] = item;
    }

    @Override
    public char pop() {
        if (isEmpty()) print(EMPTY_MESSAGE);
        else return itemArray[top--];
        return 0;
    }

    @Override
    public char peek() {
        if (isEmpty()) print(EMPTY_MESSAGE);
        else return itemArray[top];
        return 0;
    }

    @Override
    public void delete() {
        if (isEmpty()) print(EMPTY_MESSAGE);
        else top--;
    }

    private void print(String message) {
        System.out.println(message);
    }

    void printStack() {
        if (isEmpty()) print(EMPTY_MESSAGE);
        else {
            print("<<Stack>>");
            for (int i = top; i >= 0; i--) {
                System.out.println(itemArray[i]);
            }
            System.out.println();
        }
    }
}
