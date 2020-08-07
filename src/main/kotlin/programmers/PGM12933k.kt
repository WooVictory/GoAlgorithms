package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12933k {
    fun main(args: Array<String>) {
        println(solution(118372))
    }

    fun solution(n: Long): Long {
        return n.toString()
                .map { it.toString().toInt() }
                .sortedDescending()
                .joinToString("")
                .toLong()
    }

    fun solution2(n: Long): Long {
        return n.toString()
                .toList()
                .sortedDescending()
                .joinToString("")
                .toLong()
    }
}