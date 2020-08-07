package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12931k {
    fun main(args: Array<String>) {
        println(solution2(123))
        println(solution2(987))
    }

    fun solution(n: Int): Int {
        return n.toString()
                .map { it - '0' }
                .sum()
    }

    fun solution2(n: Int): Int {
        var input = n
        var answer = 0
        while (input != 0) {
            answer += input % 10
            input /= 10
        }
        return answer
    }
}