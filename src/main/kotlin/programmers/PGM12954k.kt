package programmers

/**
 * created by victory_woo on 2020/08/08
 * */
class PGM12954k {
    fun main(args: Array<String>) {
        solution(2, 5)
        solution(4, 3)
        solution(-4, 2)
    }

    fun solution(x: Int, n: Int): LongArray {
        val answer = LongArray(n)
        var index = 0
        var num = 0L
        var count = n

        while (count != 0) {
            num += x
            answer[index++] = num
            count--
        }

        println(answer)
        return answer
    }

    fun solution2(x: Int, n: Int): LongArray {
        return LongArray(n) { x.toLong() * (it + 1) }
    }
}