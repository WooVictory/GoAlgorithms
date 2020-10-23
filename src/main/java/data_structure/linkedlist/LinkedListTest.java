package data_structure.linkedlist;

/**
 * created by victory_woo on 2020/10/23
 */
public class LinkedListTest {
    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        String target = "Wed";


        linkedList.insertNode("Sun");
        linkedList.insertNode("Mon");
        linkedList.insertNode("Tue");
        linkedList.insertNode("Wed");
        linkedList.insertNode("Thu");
        linkedList.insertNode("Fri");
        linkedList.insertNode("Sat");
        linkedList.print();

        // 찾은 경우.
        System.out.println(linkedList.searchNode(target).getData());

        // 찾지 못한 경우.
        System.out.println(linkedList.searchNode("mon").getData());

        // 마지막 노드 삭제.
        linkedList.deleteNode();
        linkedList.print();

        linkedList.deleteNode();
        linkedList.print();

        linkedList.deleteNode(linkedList.searchNode("Tue").getData());
        linkedList.print();
    }
}
