package programmers

/**
 * created by victory_woo on 2020/08/09
 * */
class PGM12969k {
    fun main(args: Array<String>) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)

        val result = buildString {
            for (i in 0 until b) {
                for (j in 0 until a) {
                    append("*")
                }
                append("\n")
            }
        }

        println(result)
    }
}