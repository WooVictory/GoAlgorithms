package programmers

/**
 * created by victory_woo on 2020/08/10
 * */
class PGM67256k {
    fun main(args: Array<String>) {
        //println(solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
        // expected : LRLLLRLLRRL, actual : LRLLLRLLRRL

        println(solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left"))
        // expected : LRLLRRLLLRR, actual : LRLLLRLLLRR

        //println(solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), "right"))
        // expected : LLRLLRLLRL, actual : LLRLLRLLRL

        //println(solution(intArrayOf(0, 0, 0, 0), "left"))
    }

    fun solution(numbers: IntArray, hand: String): String {
        val map = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
                intArrayOf(11, 0, 12))

        val sb = StringBuilder()
        var left = 11
        var right = 12
        numbers.forEach { number ->
            when (number) {
                1, 4, 7 -> {
                    left = number
                    sb.append("L")
                }
                3, 6, 9 -> {
                    right = number
                    sb.append("R")
                }
                else -> {

                    val (lx, ly) = find(left, map)
                    val (rx, ry) = find(right, map)
                    val (nx, ny) = find(number, map)

                    val d1 = Math.abs(lx - nx) + Math.abs(ly - ny)
                    val d2 = Math.abs(rx - nx) + Math.abs(ry - ny)

                    when {
                        d1 < d2 -> {
                            left = number
                            sb.append("L")
                        }
                        d1 > d2 -> {
                            right = number
                            sb.append("R")
                        }
                        else -> {
                            if (hand == "right") {
                                sb.append("R")
                                right = number
                            } else {
                                sb.append("L")
                                left = number
                            }
                        }
                    }
                }
            }
        }

        return sb.toString()
    }

    private fun find(number: Int, map: Array<IntArray>): Pair<Int, Int> {
        for (row in map.indices) {
            for (col in map[row].indices) {
                if (number == map[row][col]) return Pair(row, col)
            }
        }
        return Pair(0, 0)
    }
}