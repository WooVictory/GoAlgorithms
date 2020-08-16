package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/16
 * */
class PGM42883k {
    fun main(args: Array<String>) {
        println(solution("1924",2))
        println(solution("1231234", 3))
        println(solution("4177252841", 4))
    }

    fun solution(number: String, k: Int): String {
        var count = k
        val stack = Stack<Char>()
        for (c in number.toCharArray()) {

            // 스택에 들어있는 숫자가 넣어야 할 숫자보다 작다면 스택에서 제거하고, 제거해야 하는 숫자를 감소시킨다.
            while (stack.isNotEmpty() && stack.peek() < c && count > 0) {
                stack.pop()
                count--
            }

            // 무조건 스택에 넣어준다.
            stack.push(c)
        }

        // k개 만큼 제거하지 못했을 경우, 뒤에서부터 제거한다.
        while (stack.isNotEmpty() && count > 0) {
            stack.pop()
            count--
        }

        // 붙여주고, reverse 하여 반환한다.
        return buildString {
            while (stack.isNotEmpty()) append(stack.pop())
            reverse()
        }
    }
}