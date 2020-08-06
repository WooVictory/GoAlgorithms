package programmers

/**
 * created by victory_woo on 2020/08/06
 * */
class PGM12922k {
    fun main(args: Array<String>) {
        println(solution(3))
        println(solution(4))
    }

    // 홀수 : 수
    // 짝수 : 박
    fun solution(n: Int): String {
        return buildString {
            (1..n).forEach {
                append(if (it % 2 != 0) "수" else "박")
            }
        }
    }
}