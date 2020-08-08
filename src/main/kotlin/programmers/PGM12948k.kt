package programmers

/**
 * created by victory_woo on 2020/08/08
 * */
class PGM12948k {
    fun main(args: Array<String>) {
        println(solution("01048990373"))
        println(solution("027778888"))
    }

    fun solution(phone_number: String): String {
        return (0 .. phone_number.length - 4).joinToString("") { "*" } + phone_number.takeLast(4)
    }
}