package programmers

/**
 * created by victory_woo on 2020/08/08
 * */
class PGM12940k {
    fun main(args: Array<String>) {
        solution(3, 12)
        solution(2, 5)
        solution(85, 51)
    }

    fun solution(n: Int, m: Int): IntArray {
        var a = if (n > m) n else m
        var b = if (n > m) m else n

        var r = a % b
        while (r != 0) {
            a = b
            b = r
            r = a % b
        }

        println("gcd $b")
        println("lcm ${n * m / b}")

        return intArrayOf(b, (n * m / b))
    }
}