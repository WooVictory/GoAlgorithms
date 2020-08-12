package programmers

/**
 * created by victory_woo on 2020/08/12
 * */
class PGM60057kRE {
    fun main(args: Array<String>) {
        println(solution("aabbaccc"))
        println(solution("ababcdcdababcdcd"))
        println(solution("abcabcdede"))
        println(solution("abcabcabcabcdededededede"))
        println(solution("xababcdcdababcdcd"))
    }

    fun solution(s: String): Int {
        val len = s.length
        var min = len
        var sb: StringBuilder

        // 몇 조각으로 나눌 건지에 대한 for 반복문.
        for (i in 1..(len / 2)) {
            var now: String
            var next = ""
            var count = 1
            var j = 0
            sb = StringBuilder()

            // index 를 위한 for 반복문
            // i가 몇 개를 자를지에 대한 거라면, j는 i로 인해 몇 조각으로 나뉘는지까지만 반복한다.
            while (j <= (len / i)) {
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
            min = Math.min(min, comp.length)
            println(comp)
        }

        return min
    }

    fun getCount(count: Int): String {
        return if (count > 1) "$count" else ""
    }
}