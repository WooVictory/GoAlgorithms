package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12935k {
    fun main(args: Array<String>) {
        println(solution(intArrayOf(4, 3, 2, 1)))
    }

    fun solution(arr: IntArray): IntArray {
        if (arr.size == 1) return intArrayOf(-1)

        return arr.toMutableList()
                .apply { arr.min()?.let { remove(it) } }
                .toIntArray()
    }
}