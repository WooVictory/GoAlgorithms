package data_structure.stack;

/**
 * created by victory_woo on 2020/10/09
 */
public interface Stack {
    boolean isEmpty();
    void push(char item);
    char pop();
    char peek();
    void delete();
}
