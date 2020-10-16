package data_structure.queue;

/**
 * created by victory_woo on 2020/10/10
 */
public class ArrayQueue implements Queue {
    private int front;
    private int rear;
    private int queueSize;
    private char[] queueArr;
    private final String EMPTY = "Empty";
    private final String FULL = "Full";

    public ArrayQueue(int queueSize) {
        this.front = -1;
        this.rear = -1;
        this.queueSize = queueSize;
        this.queueArr = new char[this.queueSize];
    }

    /*
     * front, rear 포인터가 같은 경우, 데이터가 없는 상태이므로 포인터를 모두 -1로 초기화.
     * front, rear 포인터가 같은 경우는 데이터가 없는 상태이므로 비어있다. 따라서 true.
     * 아닌 경우, false.
     * */
    @Override
    public boolean isEmpty() {
        if (front == rear) reset();

        return front == rear;
    }

    /*
     * 큐가 가득찬 상태인지 확인.
     * rear 포인터가 큐의 마지막 인덱스와 동일한 경우, true. 아닌 경우, false.
     * */
    @Override
    public boolean isFull() {
        return (rear == this.queueSize - 1);
    }

    /*
     * 큐에 데이터 삽입.
     * 다음 rear 포인터가 가리키는 위치에 데이터 추가.
     * */
    @Override
    public void enqueue(char item) {
        if (isFull()) {
            println(FULL);
        } else {
            queueArr[++rear] = item;
            println("Inserted Item : " + item);
        }
    }

    /*
     * 큐에서 데이터 추출 후 삭제.
     * */
    @Override
    public char dequeue() {
        if (isEmpty()) {
            println(EMPTY);
            return 0;
        } else {
            // 큐에서 삭제할 데이터 반환.
            println("Deleted Item : " + queueArr[front + 1]);

            // front 포인터는 삭제할 위치에 있는 상태이므로 다음과 같이 (front + 1) % size 로 설정.
            // front + 1 로 설정하면 front 포인터가 마지막 요소에 위치했을 경우,
            // ArrayOutOfBoundException 예외가 발생하기 때문에 (front + 1) % size 로 설정한다.
            // 큐의 사이즈가 5일 때, index 범위는 0 ~ 4
            // index of front 3 : (3+1) % 5 = 4
            // index of front 4 : (4+1) % 5 = 0
            front = (front + 1) % this.queueSize;
            return queueArr[front];
        }
    }

    /*
     * 큐의 첫 번째 데이터를 보여준다.
     * 즉, front 의 데이터를 보여준다.
     * */
    @Override
    public char peek() {
        if (isEmpty()) {
            println(EMPTY);
            return 0;
        } else {
            println("Peeked Item : " + queueArr[front + 1]);
            return queueArr[front + 1];
        }
    }

    /*
     * 큐 초기화!
     * */
    @Override
    public void clear() {
        if (isEmpty()) {
            println(EMPTY);
        } else {
            reset();
            queueArr = new char[this.queueSize]; // 새로운 큐 배열 생성.
            println("Queue is Clear!");
        }
    }

    /*
    * 큐에 저장된 모든 데이터를 출력.
    * */
    void printQueue() {
        if (isEmpty()) {
            println(EMPTY);
        } else {
            print("Queue Elements : ");
            // front 포인터는 -1 또는 삭제된 원소의 위치에 있기 때문에 +1 위치를 시작점으로 지정.
            for (int i = front + 1; i <= rear; i++) {
                print(queueArr[i] + " ");
            }
            println("");
        }
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }

    // front, rear 포인터 초기화.
    private void reset() {
        front = -1;
        rear = -1;
    }
}
