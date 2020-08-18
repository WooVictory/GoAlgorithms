package programmers

/**
 * created by victory_woo on 2020/08/18
 * */
class PGM12945k {
    fun main(args: Array<String>) {
        println(solution2(3))
        println(solution2(5))
    }

    fun solution(n: Int): Int {
        val max = 100000
        var mod = 1234567
        val f = IntArray(max + 1)
        f[0] = 0
        f[1] = 1
        f[2] = 1
        for (i in 3..max) {
            f[i] = f[i - 1] % mod + f[i - 2] % mod
        }

        return f[n] % 1234567
    }

    // todo : 재귀함수로 변경해서 풀어보기 - 시간 초과 문제 해결하기!!
    val f = IntArray(100001)
    // 재귀호출!!
    fun solution2(n: Int): Int {
        f[0] = 0
        f[1] = 1
        f[2] = 1
        return fibo(n) % 1234567
    }

    fun fibo(n: Int): Int {
        if (n > 2) return fibo(n - 1) % 1234567 + fibo(n - 2) % 1234567
        else return f[n]
    }
}