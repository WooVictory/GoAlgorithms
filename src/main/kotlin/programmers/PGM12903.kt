package programmers

/**
 * created by victory_woo on 2020/08/05
 * 가운데 글자 가져오기.
 * */

fun main(args: Array<String>) {
    println(solution("qwer"))
    println(solution("abcde"))
}

fun solution(s: String): String =
        with(s) {
            if (length % 2 == 0) return substring((length / 2 - 1)..length / 2)
            else substring(length / 2..length / 2)
        }
