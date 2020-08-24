package Sample

/**
 * created by victory_woo on 2020/08/24
 * 진법 변환 Sample.
 * */
class ConvertSample {
    fun main(args: Array<String>) {
        val (num, n) = readLine()!!.split(" ").map(String::toInt)
        println(solution(num, n))
    }

    private fun solution(num: Int, n: Int): String {
        return buildString {
            var quot = num
            var remain: Int
            while (quot > 0) {
                remain = quot % n
                quot /= n
                append(remain)
            }
        }.reversed()
    }
}