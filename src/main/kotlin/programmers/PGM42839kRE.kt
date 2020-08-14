package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/14
 * */
class PGM42839kRE {
    fun main(args: Array<String>) {
        //println(solution("17"))
        println(solution("011"))
    }

    lateinit var list: LinkedList<Int>
    lateinit var arr: Array<String>
    lateinit var check: BooleanArray
    lateinit var result: MutableList<Int>

    fun solution(numbers: String): Int {
        list = LinkedList()
        arr = numbers.map { it.toString() }.toList().toTypedArray()
        val size = numbers.length
        check = BooleanArray(size)
        result = LinkedList()

        // 순열을 통해서 만들 수 있는 모든 경우의 수를 찾는다.
        for (i in 1..size) perm(size, i)

        // 중복이 허용된 상태로 들어가기 때문에 distinct()를 사용하여 중복을 제거한다.
        result = result.distinct().toMutableList()
        println(result)

        return findPrimeNumber(result)
    }

    // 순열을 통해서 구하고 result 에 담아준다.
    private fun perm(n: Int, r: Int) {
        if (list.size == r) {
            result.add(list.joinToString("") { arr[it] }.toInt())
        } else {
            for (i in 0 until n) {
                if (!check[i]) {
                    check[i] = true
                    list.add(i)

                    perm(n, r)
                    check[i] = false
                    list.removeLast()
                }
            }
        }
    }

    // result 에 담긴 값들 중에서 소수의 갯수를 찾는다.
    // 단순하게 1과 자기 자신을 제외한 숫자들로 나누어 떨어진다면 소수가 아니다.
    // 나누어 떨어지지 않는다면 소수이다.
    // 0과 1은 건너뛴다.
    private fun findPrimeNumber(list: MutableList<Int>): Int {
        var count = 0
        for (value in list) {
            if (value == 0 || value == 1) continue
            var flag = true
            for (i in 2 until value) {
                if (value % i == 0) {
                    flag = false
                    break
                }
            }

            if (flag) count++
        }
        return count
    }
}