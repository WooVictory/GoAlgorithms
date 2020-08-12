package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/12
 * */
class PGM42746k {
    fun main(args: Array<String>) {
        println(solution(intArrayOf(6, 10, 2)))
        println(solution(intArrayOf(3, 30, 34, 5, 9)))
        println(solution(intArrayOf(0, 0, 0, 0)))
    }

    fun solution(numbers: IntArray): String {
        val arr = numbers
                .map { "$it" }
                .toTypedArray()


        Arrays.sort(arr) { o1, o2 -> (o2 + o1).compareTo(o1 + o2) }

        for (a in arr) println(a)

        if (arr[0] == "0") return "0"

        return arr.joinToString("")
    }
}