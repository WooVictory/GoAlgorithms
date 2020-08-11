package programmers

/**
 * created by victory_woo on 2020/08/11
 * */
class PGM42584k {
    fun main(args: Array<String>) {
        solution(intArrayOf(1, 2, 3, 2, 3))
    }

    fun solution(prices: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (i in prices.indices) {
            val value = prices[i]
            var count = 0
            for (j in (i + 1) until prices.size) {
                count++
                if (prices[j] < value) break
            }

            result.add(count)
        }

        println(result)

        return result.toIntArray()
    }
}