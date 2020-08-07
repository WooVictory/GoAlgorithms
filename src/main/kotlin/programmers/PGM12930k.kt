package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12930k {
    fun main(args: Array<String>) {
        println(solution("try hello world"))
    }

    fun solution(s: String): String {
        return buildString {
            var index = 0
            s.forEach { c ->
                append(if (index % 2 == 0) c.toUpperCase() else c.toLowerCase())
                index++

                if (c == ' ') index = 0
            }
        }
    }
}