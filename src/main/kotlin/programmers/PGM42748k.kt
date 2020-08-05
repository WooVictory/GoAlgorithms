package programmers

/**
 * created by victory_woo on 2020/08/05
 * */
class PGM42748k {
    fun main(args: Array<String>) {
        val commands: Array<IntArray> = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
        solution(intArrayOf(1, 5, 2, 6, 3, 7, 4), commands)
    }

    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return mutableListOf<Int>().apply {
            for (command in commands) {
                add(array.toList()
                        .subList(command[0] - 1, command[1])
                        .sorted()[command[2] - 1])
            }
        }.toIntArray()
    }

    fun solution2(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map { command ->
            array.slice(command[0] - 1 until command[1])
                    .sorted()[command[2] - 1]
        }.toIntArray()
    }

}