package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/10
 * */
class PGM12982k {
    fun main(args: Array<String>) {
        println(solution(intArrayOf(1, 3, 2, 4, 5), 9))
        println(solution(intArrayOf(2, 2, 3, 3), 10))
    }

    fun solution(d: IntArray, budget: Int): Int {
        Arrays.sort(d)
        var total = 0
        var count = 0
        d.forEach {
            total += it
            if (total <= budget) count++
        }
        return count
    }
}