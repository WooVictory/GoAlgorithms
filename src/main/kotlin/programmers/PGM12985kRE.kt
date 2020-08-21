package programmers

/**
 * created by victory_woo on 2020/08/21
 * */
class PGM12985kRE {
    fun main(args: Array<String>) {
        println(solution(8, 4,7))
        println(solution(8, 1,2))
        println(solution(8, 4,5))
    }

    fun solution(n: Int, a: Int, b: Int): Int {
        var x = a
        var y = b
        var answer = 0
        while (x != y) {
            x = (x + 1) / 2
            y = (y + 1) / 2
            answer++
        }
        return answer
    }
}