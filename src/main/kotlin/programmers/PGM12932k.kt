package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12932k {
    fun main(args: Array<String>) {
        solution2(12345)
    }

    fun solution(n: Long): IntArray {
        var input = n
        val result = mutableListOf<Long>()
        while (input != 0L) {
            result.add(input % 10)
            input /= 10
        }

        val answer = IntArray(result.size)
        for (i in answer.indices) {
            answer[i] = result[i].toInt()
        }

        return answer
    }

    fun solution2(n: Long): IntArray {
        return n.toString()
                .reversed()
                .map { (it - '0') }
                .toIntArray()
    }
}