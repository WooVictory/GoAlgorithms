package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/28
 * */
class PGM43163 {
    fun main(args: Array<String>) {
        //println(solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog")))
        println(solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log")))
    }

    lateinit var visit: BooleanArray
    private var result = 0
    fun solution(begin: String, target: String, words: Array<String>): Int {
        visit = BooleanArray(words.size)

        bfs(begin, target, words)
        return if (result != 0) result else 0
    }


    private fun bfs(begin: String, target: String, words: Array<String>) {
        val q = LinkedList<Node>().apply { add(Node(begin, 0)) }

        while (q.isNotEmpty()) {
            val cur = q.remove()
            val word = cur.name
            val count = cur.count

            if (target == word) {
                result = count
                return
            }

            for (i in words.indices) {
                if (!visit[i] && check(word, words[i])) {
                    visit[i] = true
                    q.add(Node(words[i], count + 1))
                }
            }
        }
    }

    private fun check(a: String, b: String): Boolean {
        var count = 0
        a.forEachIndexed { index, c ->
            if (a[index] != b[index]) count++
        }

        return count == 1
    }

    data class Node(
            val name: String,
            val count: Int
    )
}