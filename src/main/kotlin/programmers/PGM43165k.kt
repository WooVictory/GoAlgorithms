package programmers

/**
 * created by victory_woo on 2020/08/17
 * */
class PGM43165k {
    fun main(args: Array<String>) {
        println(solution(intArrayOf(1, 1, 1, 1, 1), 3))
    }

    private var count = 0
    fun solution(numbers: IntArray, target: Int): Int {
        solve(numbers, target, 0, 0)
        return count
    }

    private fun solve(numbers: IntArray, target: Int, index: Int, sum: Int) {
        // numbers 순회를 마침.
        if (index == numbers.size) {
            // sum 이 target 이 되었다면 카운트를 세어주고 함수를 종료한다.
            if (target == sum) count++

            // 순회를 마치면 해당 함수 호출을 종료한다.
            return
        }

        solve(numbers, target, index + 1, sum + numbers[index]) // 더하는 경우.
        solve(numbers, target, index + 1, sum - numbers[index]) // 빼는 경우.
    }
}