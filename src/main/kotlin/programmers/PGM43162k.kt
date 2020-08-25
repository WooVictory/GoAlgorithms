package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/26
 * */
class PGM43162k {
    fun main(args: Array<String>) {
        println(solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))))
    }

    private lateinit var visit: BooleanArray
    private lateinit var map: Array<IntArray>
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        visit = BooleanArray(n)
        map = computers

        (0 until n).forEach {
            if (!visit[it]) {
                answer++
                //dfs(it, n)
                bfs(it, n)
            }
        }
        return answer
    }

    private fun dfs(v: Int, n: Int) {
        if (visit[v]) return
        visit[v] = true

        (0 until n).forEach {
            if (!visit[it] && map[v][it] == 1) dfs(it, n)
        }
    }

    private fun bfs(v: Int, n: Int) {
        val q = LinkedList<Int>()
        q.add(v)
        visit[v] = true

        while (q.isNotEmpty()) {
            val cur = q.remove()

            (0 until n).forEach {
                if (!visit[it] && map[cur][it] == 1) {
                    q.add(it)
                    visit[it] = true
                }
            }
        }
    }
}