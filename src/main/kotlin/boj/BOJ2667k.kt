package boj

import java.util.*

/**
 * created by victory_woo on 2020/08/26
 * */
class BOJ2667k {
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    lateinit var map: Array<IntArray>
    lateinit var visit: Array<BooleanArray>
    private var n = 0
    lateinit var result: MutableList<Int>

    fun main(args: Array<String>) {
        n = readLine()!!.toInt()
        map = Array(n) { IntArray(n) }
        visit = Array(n) { BooleanArray(n) }
        result = mutableListOf()

        repeat(n) { row ->
            val r = readLine()!!
            for (i in r.indices) {
                map[row][i] = r[i].toInt() - 48
            }
        }

        var answer = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visit[i][j] && map[i][j] == 1) {
                    answer++
                    bfs(i, j)
                }
            }
        }

        result.sort()
        println(result)
        println(buildString {
            append(result.size).append("\n")
            result.forEachIndexed { index, i ->
                if (index == result.size - 1) append(i)
                else append(i).append("\n")
            }
        })
    }

    private fun bfs(x: Int, y: Int) {
        val q = LinkedList<Node>()
        q.add(Node(x, y))
        visit[x][y] = true
        var count = 1

        while (!q.isEmpty()) {
            val cur = q.remove()

            for (i in dx.indices) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue

                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    q.add(Node(nx, ny))
                    visit[nx][ny] = true
                    count++
                }
            }
        }

        result.add(count)
    }

    data class Node(val x: Int, val y: Int)
}