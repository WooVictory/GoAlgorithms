package programmers

/**
 * created by victory_woo on 2020/08/06
 * */
class PGM12921k {
    fun main(args: Array<String>) {
        println(solution(10))
    }

    fun solution(n: Int): Int {
        val check = BooleanArray(n + 1)

        for (i in 2..n) {
            if (check[i]) continue

            var j = i + i
            while (j <= n) {
                check[j] = true
                j += i
            }
        }

        var count = 0
        (2..n).forEach { if (!check[it]) count++ }
        return count
    }
}