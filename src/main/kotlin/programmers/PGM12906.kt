package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/05
 * 같은 숫자는 싫어. kotlin ver.
 * */

fun main(args: Array<String>) {
    println(solution(intArrayOf(1, 1, 3, 3, 0, 1, 1)))
    println(solution(intArrayOf(4, 4, 4, 3, 3)))
}

fun solution(arr: IntArray): IntArray {
    val q = LinkedList<Int>()
    var current = 10

    for (a in arr) {
        if (a != current) {
            q.add(a)
            current = a
        }
    }

    val result = mutableListOf<Int>()
    while (!q.isEmpty()) result.add(q.poll())

    println(result)
    return result.toIntArray()
}
