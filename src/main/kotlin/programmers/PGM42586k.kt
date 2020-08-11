package programmers

/**
 * created by victory_woo on 2020/08/11
 * */
class PGM42586k {
    fun main(args: Array<String>) {
        solution(intArrayOf(93, 33, 55), intArrayOf(1, 30, 5))
    }

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val days = mutableListOf<Int>()
        for (i in progresses.indices) {
            var day = 0
            while (progresses[i] < 100) {
                progresses[i] += speeds[i]
                day++
            }

            days.add(day)
        }

        var max = days[0]
        val result = mutableListOf<Int>()
        var count = 1
        for (i in 1 until days.size) {
            if (days[i] <= max) {
                count++
            } else {
                result.add(count)
                count = 1
                max = days[i]
            }


            if (i == days.size - 1) result.add(count)
        }
        println(result)
        return result.toIntArray()
    }
}