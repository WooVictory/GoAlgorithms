package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12934k {
    fun main(args: Array<String>) {
        println(solution(121))
        println(solution(3))
    }

    fun solution(n: Long): Long {
        val result = Math.sqrt(n.toDouble()).toLong()
        return if (result * result == n) (result + 1) * (result + 1)
        else -1
    }
}