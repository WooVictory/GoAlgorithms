package programmers

/**
 * created by victory_woo on 2020/08/05
 * */
class PGM12910k {
    fun main(args: Array<String>) {
        //solution(intArrayOf(5, 9, 7, 10), 5)
        //solution(intArrayOf(2, 36, 1, 3), 1)
        solution(intArrayOf(3, 2, 6), 10)
    }

    fun solution(arr: IntArray, divisor: Int): IntArray {
        val result = arr.filter { it % divisor == 0 }
        return if (result.isEmpty()) intArrayOf(-1)
        else result.sortedDescending().toIntArray()
    }
}