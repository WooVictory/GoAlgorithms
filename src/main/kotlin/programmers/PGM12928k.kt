package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12928k {
    fun main(args: Array<String>) {
        println(solution(12))
        println(solution(5))
    }

    fun solution(n: Int): Int {
        return (1..n).asSequence()
                .filter { n % it == 0 }
                .sum()
    }
}