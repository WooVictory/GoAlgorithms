package programmers

/**
 * created by victory_woo on 2020/08/20
 * */
class PGM12985k {
    fun main(args: Array<String>) {
        println(solution(8, 4, 7))
        println(solution(8, 2, 3))
        println(solution(8, 1, 2))
    }

    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var n = a
        var m = b
        while (n != m) {
            n = (n + 1) / 2
            m = (m + 1) / 2
            answer++
        }
        return answer
    }
}