package programmers

/**
 * created by victory_woo on 2020/08/19
 * */
class PGM12977k {
    fun main(args: Array<String>) {
        //println(solution(intArrayOf(1, 2, 3, 4)))
        println(solution(intArrayOf(1, 2, 7, 6, 4)))
    }

    lateinit var check: IntArray
    lateinit var NUMS: IntArray
    var count = 0
    fun solution(nums: IntArray): Int {
        // num 배열에서 3개를 뽑기 때문!1
        check = IntArray(3)
        NUMS = nums
        comb(nums.size, 3, 0, 0)
        return count
    }

    private fun comb(n: Int, r: Int, index: Int, target: Int) {
        if (r == 0) {
            check()
            return
        }

        if (n == target) return
        check[index] = target

        comb(n, r - 1, index + 1, target + 1)
        comb(n, r, index, target + 1)
    }

    private fun check() {
        var total = 0
        check.map { total += NUMS[it] }
        var flag = true

        for (i in 2 until total) {
            if (total % i == 0) {
                flag = false
                break
            }
        }

        if (flag) {
            count++
            println(total)
        }
    }
}