package data_structure.linkedlist;

/**
 * created by victory_woo on 2020/10/23
 */
class ListNode {
    private String data;
    public ListNode next;

    public ListNode() {
        this.data = null;
        this.next = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(String data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data='" + data + '\'' +
                ", next=" + next +
                '}';
    }
}
