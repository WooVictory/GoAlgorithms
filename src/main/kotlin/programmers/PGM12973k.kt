package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/14
 * */
class PGM12973k {

    fun main(args: Array<String>) {
        println(solution("baabaa"))
        println(solution("cdcd"))
    }

    fun solution(s: String): Int {
        val stack = Stack<Char>()
        s.forEach {
            if (stack.isNotEmpty() && stack.peek() == it) stack.pop()
            else stack.push(it)
        }

        return if (stack.isEmpty()) 1 else 0
    }
}