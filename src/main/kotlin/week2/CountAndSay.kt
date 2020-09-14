package week2

/**
 * created by victory_woo on 2020/09/14
 * */
class CountAndSay {
    fun main(args: Array<String>) {
        println(countAndSay(1)) // 1
        println(countAndSay(2)) // 11
        println(countAndSay(3)) // 21
        println(countAndSay(4)) // 1211
        println(countAndSay(5)) // 111221
        println(countAndSay(6))


    }

    // 카카오 기출 문제 중 문자열 압축과 비슷!
    private fun countAndSay(n: Int): String {
        if (n == 1) return "$n"
        if (n == 2) return "11"

        var result = "1"
        for (i in 0 until n - 1) {
            var now: Char
            var next = if (i == 0) '1' else ' '
            var count = 1
            val sb = StringBuilder()
            for (j in 0 until result.length - 1) {
                now = result[j]
                next = result[j + 1]
                if (now == next) count++
                else {
                    sb.append(count).append(now)
                    count = 1
                }
            }

            sb.append(count).append(next)
            result = sb.toString()
        }
        return result
    }
}