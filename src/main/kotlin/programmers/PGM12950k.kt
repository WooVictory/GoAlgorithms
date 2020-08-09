package programmers

/**
 * created by victory_woo on 2020/08/09
 * */
class PGM12950k {
    fun main(args: Array<String>) {
        solution(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)), arrayOf(intArrayOf(3, 4), intArrayOf(5, 6)))
        solution(arrayOf(intArrayOf(1), intArrayOf(2)), arrayOf(intArrayOf(3), intArrayOf(4)))
    }

    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        for (i in arr1.indices) {
            for (j in arr1[i].indices) {
                arr1[i][j] = arr1[i][j] + arr2[i][j]
            }
        }

        return arr1
    }
}