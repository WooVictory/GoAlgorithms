package week3

import java.util.*

/**
 * created by victory_woo on 2020/09/18
 * */
class BinaryTreeLevel {
    fun main(args: Array<String>) {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)

        val list = levelOrder(root)
        for (i in list) {
            for (value in i) print("$value ")
            println()
        }
    }

    private fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        var contains: MutableList<Int>
        val q = LinkedList<TreeNode>()
        root?.let { q.add(it) }

        while (!q.isEmpty()) {
            contains = mutableListOf()

            val size = q.size
            for (i in 0 until size) {
                val node = q.remove()
                contains.add(node.`val`)

                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
            }

            result.add(contains)
        }
        return result.toList()
    }


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}