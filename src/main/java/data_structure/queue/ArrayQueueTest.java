package data_structure.queue;

/**
 * created by victory_woo on 2020/10/10
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue('A');
        queue.enqueue('B');
        queue.enqueue('C');
        queue.enqueue('D');
        queue.enqueue('E');
        queue.enqueue('F');
        queue.printQueue();


        queue.dequeue();
        queue.dequeue();
        queue.peek();
        queue.printQueue();

        queue.clear();
        queue.printQueue();

        queue.enqueue('A');
        queue.printQueue();
    }
}
