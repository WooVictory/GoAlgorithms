package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/06
 * */
class PGM64061k {
    fun main(args: Array<String>) {
        val board = arrayOf(intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 3),
                intArrayOf(0, 2, 5, 0, 1),
                intArrayOf(4, 2, 4, 4, 2),
                intArrayOf(3, 5, 1, 3, 1))

        println(solution(board, intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)))
    }

    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val stack = Stack<Int>()
        var count = 0

        for (line in moves) {
            for (i in board.indices) {
                if (board[i][line - 1] != 0) {
                    if (stack.isNotEmpty() && stack.peek() == board[i][line - 1]) {
                        count += 2
                        stack.pop()
                    } else {
                        stack.push(board[i][line - 1])
                    }
                    board[i][line - 1] = 0
                    break
                }
            }
        }

        return count
    }
}