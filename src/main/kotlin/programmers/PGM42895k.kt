package programmers

/**
 * created by victory_woo on 2020/08/25
 * */
class PGM42895k {
    fun main(args: Array<String>) {
        println(solution(5, 12))
    }

    private var answer = -1
    fun solution(N: Int, number: Int): Int {
        dfs(N, number, 0, 0)
        return answer
    }

    private fun dfs(n: Int, number: Int, count: Int, sum: Int) {
        var nn = n
        if (count > 8) {
            answer = -1
            return
        }

        if (sum == number) {
            if (answer == -1 || answer > count) {
                answer = count
            }
            return
        }

        for (i in 1 until 9 - count) {
            dfs(n, number, count + i, sum + nn)
            dfs(n, number, count + i, sum - nn)
            dfs(n, number, count + i, sum * nn)
            dfs(n, number, count + i, sum / nn)
            nn = nn * 10 + n
        }
    }
}