package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/10
 * */
class PGM42889k {
    fun main(args: Array<String>) {
        solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3))
        solution(4, intArrayOf(4, 4, 4, 4, 4))
    }

    fun solution(N: Int, stages: IntArray): IntArray {
        val list = mutableListOf<Fail>()
        var length = stages.size
        for (i in 1..N) {
            var count = 0
            for (j in stages) {
                if (j == N + 1) continue

                if (j == i) count++
            }

            if (length == 0) list.add(Fail(i, 0.toDouble()))
            else list.add(Fail(i, (count / length.toDouble())))

            length -= count
        }

        list.sortWith(Comparator { o1, o2 ->
            if (o1.failRate == o2.failRate) o1.index - o2.index
            else o2.failRate.compareTo(o1.failRate)
        })

        return list.map { it.index }
                .toIntArray()
    }

    fun solution2(N: Int, stages: IntArray): IntArray {
        var length = stages.size
        val result = mutableListOf<Fail>()
        for (i in 1..N) {
            var count = 0
            for (j in stages) {
                if (j == N + 1) continue

                if (i == j) count++
            }

            if (length == 0) result.add(Fail(i, 0.toDouble()))
            else result.add(Fail(i, (count / length.toDouble())))

            length -= count
        }

        result.sortWith(kotlin.Comparator { o1, o2 ->
            if (o1.failRate == o2.failRate) o1.index - o2.index
            else o2.failRate.compareTo(o1.failRate)
        })

        return result.map { it.index }
                .toIntArray()

    }

    data class Fail(val index: Int, val failRate: Double)
}