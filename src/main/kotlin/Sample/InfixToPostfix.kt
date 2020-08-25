package Sample

import java.util.*
import kotlin.collections.HashMap

/**
 * created by victory_woo on 2020/08/25
 * */
class InfixToPostfix {
    fun main(args: Array<String>) {
        solution("3*5-6/2")
    }

    fun solution(s: String) {
        val operators = s.filter { it.isDigit().not() }
                .toMutableList()
                .distinct()

        val map = HashMap<String, Int>()
        for (c in operators) {
            if (c == '*' || c == '/') map["$c"] = 2
            else map["$c"] = 1
        }

        val sb = StringBuilder()
        val equation = mutableListOf<String>()
        val operations = Stack<String>()

        s.forEach {
            if (isOperations(it)) {
                equation.add(sb.toString())
                sb.delete(0, sb.length)
                while (operations.isNotEmpty() && map["$it"]!! <= map[operations.peek()]!!) {
                    equation.add(operations.pop())
                }
                operations.push("$it")
            } else {
                sb.append(it)
            }
        }

        equation.add(sb.toString())
        while (operations.isNotEmpty()) {
            equation.add(operations.pop())
        }

        println("후위 표기식 : $equation")

        val stack = Stack<Long>()
        for (e in equation) {
            if (map.containsKey(e)) {
                val b = stack.pop()
                val a = stack.pop()

                stack.push(calculate(a, b, e))
            } else {
                stack.push(e.toLong())
            }
        }

        println(Math.abs(stack.pop()))
    }

    private fun calculate(a: Long, b: Long, e: String): Long {
        return when (e) {
            "+" -> (a + b)
            "-" -> (a - b)
            "*" -> (a * b)
            else -> (a / b)
        }
    }

    private fun isOperations(c: Char): Boolean {
        return c == '+' || c == '/' || c == '*' || c == '-'
    }
}