package programmers

/**
 * created by victory_woo on 2020/08/06
 * */
class PGM12901k {
    fun main(args: Array<String>) {
        println(solution(5, 24))
    }

    fun solution(a: Int, b: Int): String {
        val dayOfWeek = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
        val month = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        var total = 0
        (0 until a - 1).forEach { total += month[it] }
        total += b
        return dayOfWeek[total % 7]
    }
}