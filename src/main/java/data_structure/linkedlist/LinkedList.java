package data_structure.linkedlist;

/**
 * created by victory_woo on 2020/10/23
 */
public class LinkedList {
    private ListNode head;
    private final String NOT = "Not";

    public LinkedList() {
        this.head = null;
    }

    /*
     * Node 삽입 - 마지막에 삽입.
     * head 가 null 이라면 head 가 newNode 를 참조하게 한다.
     *
     * head 가 null 아니라면, head 를 이용하여 마지막 노드를 찾는다.
     * 그리고 그 마지막이 newNode 를 가리키도록 한다.
     * */
    public void insertNode(String data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            this.head = newNode;
        } else {
            ListNode lastNode = head;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            lastNode.next = newNode;
        }
    }


    /*
     * Node 삭제 - 마지막 노드 삭제
     * head == null -> 모든 노드가 삭제되었음을 뜻하므로 return.
     *
     * head.next == null -> 노드가 1개 남았을 때이므로, head = null 을 통해 노드와의 연결을 끊는다.
     *
     * preNode : 삭제할 노드 이전의 노드.
     * tempNode : 마지막을 찾기 위해 사용하는 노드.
     *
     * tempNode 가 마지막인 null 까지 가고.
     * preNode.next = null 을 통해 마지막 노드와의 연결을 끊는다.
     * */
    public void deleteNode() {
        ListNode preNode, tempNode;

        if (head == null) return;

        if (head.next == null) head = null;
        else {
            preNode = head;
            tempNode = head.next;

            while (tempNode.next != null) {
                preNode = tempNode;
                tempNode = tempNode.next;
            }

            preNode.next = null;
        }
    }

    /*
     * Node 삭제 - 중간 노드 삭제.
     * 3 -> 10 -> 2 -> 5
     *
     * 위의 경우에서 삭제하려는 노드가 3인 경우.
     * 삭제하려는 값인 3이 preNode.getData()와 일치하므로
     * head 가 preNode 의 next 를 가리키도록 하고 preNode 가 next 와의 연결을 끊는다.
     *
     * 위의 경우에서 삭제하려는 노드가 5처럼 마지막인 경우.
     * preNode 가 삭제할 노드의 이전 노드를 가리키기 때문에
     * preNode.next = null 로 설정하여 연결을 끊는다.
     *
     * 위의 경우에서 삭제하려는 노드가 2처럼 중간에 위치할 경우.
     * preNode, tempNode 의 값을 한칸씩 뒤로 미뤄가면서 target 이 되는 값을 찾아야 한다.
     *
     * */
    public void deleteNode(String data) throws Exception {
        if (data.equals(NOT)) throw new Exception("This Data does not exist.");
        ListNode preNode = head;
        ListNode tempNode = head.next;

        if (data.equals(preNode.getData())) {
            head = preNode.next;
            preNode.next = null;
        } else {
            while (tempNode != null) {
                if (data.equals(tempNode.getData())) {
                    if (tempNode.next == null) {
                        preNode.next = null;
                    } else {
                        preNode.next = tempNode.next;
                        tempNode.next = null;
                    }
                    break;
                } else {
                    preNode = tempNode;
                    tempNode = tempNode.next;
                }
            }
        }
    }

    /*
     * Node 탐색.
     * tempNode 가 null 이 아닐때까지 탐색하면서
     * 주어진 데이터와 tempNode 의 data 가 일치하는 경우, 해당 tempNode 반환.
     *
     * 데이터가 일치하지 않는 경우, tempNode 다음의 노드를 확인하기 위해 다음 노드를 가리킨다.
     *
     * 데이터가 없다면 null 반환.
     * */
    public ListNode searchNode(String data) {
        ListNode tempNode = this.head;

        while (tempNode != null) {
            if (data.equals(tempNode.getData())) return tempNode;
            else tempNode = tempNode.next;
        }

        return new ListNode(NOT);
    }

    public void print() {
        ListNode tempNode = this.head;

        while (tempNode != null) {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}
