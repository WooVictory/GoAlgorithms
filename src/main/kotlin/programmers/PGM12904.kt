package programmers

/**
 * created by victory_woo on 2020/09/03
 * */
class PGM12904 {
    fun main(args: Array<String>) {
        println(solution("abcdcba"))
        println(solution("abacde"))
    }

    fun solution(s: String): Int {
        for (i in s.length - 1 downTo 0) {
            var start = 0
            var end = i

            while (end < s.length) {
                if (isPalindrome(s, start, end)) {
                    return i + 1
                }

                start++
                end++
            }
        }
        return 1
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        val mid = (end - start + 1) / 2
        for (i in 0 until mid) {
            val a = s[start + i]
            val b = s[end - i]
            if (a != b) return false
        }
        return true
    }
}