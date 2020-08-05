package programmers

/**
 * created by victory_woo on 2020/08/05
 * */
class PGM12917k {

    fun main(args: Array<String>) {
        println(solution("Zbcdefg"))
    }

    private fun solution(s: String): String {
        return s.toList()
                .sortedDescending()
                .joinToString("")

        /*return buildString {
            s.toList()
                    .sorted()
                    .reversed()
                    .forEach { append(it) }
        }*/
    }
}