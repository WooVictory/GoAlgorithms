package programmers

/**
 * created by victory_woo on 2020/08/17
 * */
class PGM12909k {
    fun main(args: Array<String>) {
        println(solution("()()"))
        println(solution("(())()"))
        println(solution(")()("))
        println(solution("(()("))
    }

    fun solution(s: String): Boolean {
        if (s.length % 2 != 0) return false

        var count = 0
        s.forEach {
            if (it == '(') count++
            else count--

            if (count < 0) return false
        }

        return count == 0
    }
}