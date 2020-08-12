package programmers

/**
 * created by victory_woo on 2020/08/12
 * */
class PGM42586kRE {
    fun main(args: Array<String>) {
        solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
    }

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        // 1. 작업을 완료해서 배포하기 위해서는 몇 일이 걸리는지 계산한다.
        val days = mutableListOf<Int>()
        for (i in progresses.indices) {
            var day = 0

            while (progresses[i] < 100) {
                progresses[i] += speeds[i]
                day++
            }

            days.add(day)
        }

        // 2. 함께 배포나갈 수 있는지 확인하여 result 에 담는다.
        val result = mutableListOf<Int>()
        var max = days[0]
        var count = 1

        for (i in 1 until days.size) {
            if (days[i] <= max) {
                count++
            } else {
                result.add(count)
                count = 1
                max = days[i]
            }
        }

        // 마지막 count 는 처리되지 않기 때문에 추가해줘야 한다.
        result.add(count)

        println(result)

        return result.toIntArray()
    }
}