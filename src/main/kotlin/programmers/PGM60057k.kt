package programmers

/**
 * created by victory_woo on 2020/08/11
 * */
class PGM60057k {
    fun main(args: Array<String>) {
        //println(solution("aabbaccc"))
        //println(solution("ababcdcdababcdcd"))
        println(solution("abcabcabcabcdededededede"))
    }

    fun solution(s: String): Int {
        val len = s.length
        var min = len
        var sb: StringBuilder
        for (i in 1..len / 2) {
            sb = StringBuilder()
            var j = 0
            var count = 1
            var now: String
            var next = ""
            while (j <= len / i) {
                val start = i * j
                var end = i * (j + 1)

                if (end > len) end = len

                now = next
                next = s.substring(start, end)
                if (now == next) {
                    count++
                } else {
                    sb.append(getCount(count)).append(now)
                    count = 1
                }

                j++
            }

            sb.append(getCount(count)).append(next)

            val comp = sb.toString()
            println(comp)
            min = Math.min(min, comp.length)

        }
        return min
    }

    private fun getCount(count: Int): String {
        return if (count > 1) "$count"
        else ""
    }
}