package programmers

/**
 * created by victory_woo on 2020/08/05
 * */

class PGM12918k {
    fun main(args: Array<String>) {
        println(solution("a234"))
        println(solution("1234"))
    }

    private fun solution(s: String): Boolean {
        return validateLength(s) && validateNumber(s)
    }

    private fun validateLength(s: String): Boolean = s.length == 4 || s.length == 6
    private fun validateNumber(s: String): Boolean {
        return s.filter { it.isDigit() }
                .length == s.length
        /*for (c in s.toCharArray()) if (!c.isDigit()) return false

        return true*/
    }
}
