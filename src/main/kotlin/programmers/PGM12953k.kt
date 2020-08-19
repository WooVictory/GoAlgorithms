package programmers

/**
 * created by victory_woo on 2020/08/19
 * */
class PGM12953k {
    fun main(args: Array<String>) {
        println(solution(intArrayOf(2, 6, 8, 14)))
        println(solution(intArrayOf(1, 2, 3)))
    }

    fun solution(arr: IntArray): Int {
        var lcm = arr[0]
        for (i in 1 until arr.size) {
            lcm = getLcm(lcm, arr[i])
        }
        return lcm
    }

    private fun getLcm(a: Int, b: Int): Int {
        return if (a <= 0 || b <= 0) -1
        else (a * b) / getGcd(a, b)
    }

    // 유클리드 호제법을 이용하여 최대 공약수를 구한다.
    private fun getGcd(n: Int, m: Int): Int {
        var a = n
        var b = m
        var r = a % b
        while (r != 0) {
            a = b
            b = r
            r = a % b
        }
        return b
    }
}