package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/14
 * */
class PGM42839k {
    fun main(args: Array<String>) {
        //println(solution("17"))
        println(solution("011"))
    }

    val list = LinkedList<Int>()
    var result = mutableListOf<Int>()
    fun solution(numbers: String): Int {
        val n = numbers.length
        val check = BooleanArray(n)
        for (i in 1..n) {
            perm(n, i, check, numbers)
        }

        var answer = 0

        result = result.distinct().toMutableList()
        for (value in result) {
            var flag = true
            if (value == 1 || value == 0) continue
            for (i in 2 until value) {
                if (value % i == 0) {
                    flag = false
                    break
                }
            }

            if (flag) answer++
        }
        println(result)
        return answer
    }

    private fun perm(n: Int, r: Int, check: BooleanArray, numbers: String) {
        if (list.size == r) {
            result.add(toIntValue(list, numbers))
        } else {
            for (i in 0 until n) {
                if (!check[i]) {
                    check[i] = true
                    list.add(i)

                    perm(n, r, check, numbers)

                    check[i] = false
                    list.removeLast()
                }
            }
        }
    }

    private fun toIntValue(list: LinkedList<Int>, numbers: String): Int {
        return list.map { numbers[it] }
                .joinToString("")
                .toInt()
    }
}