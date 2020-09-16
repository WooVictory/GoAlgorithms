package week3

/**
 * created by victory_woo on 2020/09/14
 * */
class DeleteNodeInALinkedList {
    fun main(args: Array<String>) {

    }

    fun deleteNode(node: ListNode?) {
        node!!.value = node!!.next!!.value
        node!!.next = node!!.next!!.next!!
    }

    class ListNode(var value: Int) {
        var next: ListNode? = null
    }
}