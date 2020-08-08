package programmers

/**
 * created by victory_woo on 2020/08/08
 * */
class PGM12943k {
    fun main(args: Array<String>) {
        println(solution2(6))
        println(solution2(16))
        println(solution2(626331))
    }

    fun solution(num: Int): Int {
        var input = num.toLong()
        var count = 0
        while (input != 1L) {
            if (input % 2 == 0L) input /= 2
            else if (input % 2 != 0L) input = (input * 3) + 1
            count++

            if (count > 500) {
                count = -1
                break
            }
        }
        return count
    }

    fun solution2(num: Int): Int {
        return collatzAlgorithm(num.toLong(), 0)
    }

    fun collatzAlgorithm(num: Long, count: Int): Int {
        return when {
            num == 1L -> count
            count > 500 -> -1
            else -> collatzAlgorithm(if (num % 2 == 0L) num / 2 else (num * 3) + 1, count + 1)
        }
    }
}