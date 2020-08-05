package programmers

/**
 * created by victory_woo on 2020/08/05
 * */

class PGM12916k {
    fun main(args: Array<String>) {
        println(solution("pPoooyY"))
        println(solution("Pyy"))
    }

    private fun solution(s: String): Boolean {
        var count = 0

        s.toLowerCase().forEach {
            if (it == 'p') count++
            if (it == 'y') count--
        }
        return count == 0
    }
}
