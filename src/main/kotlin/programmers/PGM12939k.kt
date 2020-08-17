package programmers

/**
 * created by victory_woo on 2020/08/17
 * */
class PGM12939k {
    fun main(args: Array<String>) {
        println(solution("1 2 3 4"))
        println(solution("-1 -2 -3 -4"))
        println(solution("-1 -1"))
    }

    fun solution(s: String): String {
        val list = s.split(" ")
                .map { it.toInt() }
                .toList()
        return "${list.min()} ${list.max()}"
    }
}