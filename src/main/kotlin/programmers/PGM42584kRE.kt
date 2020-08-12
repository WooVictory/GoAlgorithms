package programmers

/**
 * created by victory_woo on 2020/08/12
 * */
class PGM42584kRE {
    fun main(args: Array<String>) {
        solution(intArrayOf(1, 2, 3, 2, 3))
    }

    /*
    * 시간 복잡도를 줄이기 위해 count 를 먼저 진행한다.
    * 이후, 주식 가격이 떨어졌다면 break 를 통해 반복문을 빠져 나간다.
    * 이를 통해서 끝까지 돌지 않아도 되며, 시간 복잡도를 어느정도 줄일 수 있다.
    * */
    fun solution(prices: IntArray): IntArray {
        val result = IntArray(prices.size)
        for (i in prices.indices) {
            val value = prices[i]
            var count = 0
            for (j in (i + 1) until prices.size) {
                count++

                if (prices[j] < value) break
            }

            result[i] = count
        }
        return result
    }
}