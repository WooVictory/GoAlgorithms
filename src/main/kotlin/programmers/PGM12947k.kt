package programmers

/**
 * created by victory_woo on 2020/08/08
 * */
class PGM12947k {
    fun main(args: Array<String>) {
        println(solution(10))
        println(solution(11))
        println(solution(12))
        println(solution(13))

    }

    fun solution(x: Int): Boolean {
        val sum = x.toString()
                .map { (it - '0') }
                .sum()
        return x % sum == 0
    }

    fun solution2(x: Int): Boolean {
        var sum = 0
        var input = x

        while (input > 0) {
            sum += input % 10
            input /= 10
        }

        return (x % sum == 0)
    }
}