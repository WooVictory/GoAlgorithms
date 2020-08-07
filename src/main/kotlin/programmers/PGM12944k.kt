package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12944k {
    fun main(args: Array<String>) {
        println(solution(intArrayOf(1, 2, 3, 4)))
        println(solution(intArrayOf(5,5)))
    }

    fun solution(arr: IntArray): Double {
        return arr.average()
    }
}