package data_structure.queue;

/**
 * created by victory_woo on 2020/10/10
 */
public interface Queue {
    boolean isEmpty();

    boolean isFull();

    void enqueue(char item);

    char dequeue();

    char peek();

    void clear();
}
