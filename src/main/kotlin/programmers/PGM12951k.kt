package programmers

/**
 * created by victory_woo on 2020/08/18
 * */
class PGM12951k {
    fun main(args: Array<String>) {
        println(solution("for the last week"))
        println(solution("3people unFollowed me"))
    }

    fun solution2(s: String): String {
        val arr = s.toLowerCase().split(" ")

        return arr.joinToString("") {
            if (it.isNotEmpty()) {
                if (it[0].isLowerCase()) it[0].toUpperCase() + it.substring(1) + " "
                else "$it "
            } else it
        }.trim()
    }

    fun solution(s: String): String {
        val input = s.toLowerCase().split(" ").toMutableList()

        input.forEachIndexed { index, word ->
            if (word.isNotEmpty()) {
                val arr = s.toCharArray()
                arr[0] = arr[0].toUpperCase()
                input[index] = String(arr)
            }
        }

        var result = input[0]
        for (i in 1 until input.size) result += " " + input[i]
        return result
    }
}