package programmers

/**
 * created by victory_woo on 2020/08/17
 * */
class PGM42747k {
    fun main(args: Array<String>) {
        println(solution(intArrayOf(3, 0, 6, 1, 5)))
    }

    fun solution(citations: IntArray): Int {
        val size = citations.max() ?: return citations[0]
        var max = 0

        for (i in 1..size) {
            var upCount = 0
            var downCount = 0

            for (value in citations) {
                if (i <= value) upCount++
                else downCount++
            }

            if (i in downCount..upCount) max = i
        }

        return max
    }
}