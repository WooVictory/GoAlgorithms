package Sample

import java.util.*

/**
 * created by victory_woo on 2020/08/25
 * */
class ToPostfixSample {
    fun main(args: Array<String>) {
        solution("3*5-6/2")
    }

    fun solution(input: String) {
        // 1. 문자열에서 연산자를 구분하여 빼준다.
        val list = input
                .filter { it.isDigit().not() }
                .toList()
                .distinct()

        // 2. map 을 사용하여 연산자에 우선순위 부여.
        val map = HashMap<String, Int>()
        list.forEach {
            if (it == '*' || it == '/') map["$it"] = 2
            else map["$it"] = 1
        }

        // 3. 스택을 사용하여 중위 표기법을 후위 표기법으로 변환한다.
        val operands = StringBuilder() // 숫자를 만든다.
        val equation = mutableListOf<String>() // 후위 표기식을 저장할 방정식.
        val operators = Stack<Char>() // 연산자를 저장하는 스택.

        input.forEach {
            // 연산자인 경우.
            if (isOperators(it)) {
                equation.add(operands.toString()) // 방정식에 연산자를 만나기 전까지 찾은 피연산자를 넣는다.
                operands.delete(0, operands.length) // 피연산자를 지운다.

                // 연산자를 저장하는 스택이 비어있지 않은지 확인하고
                // 현재 연산자의 우선순위와 스택에 가장 위에 있는 우선순위를 비교한다.
                // 우선순위가 높은 연산자는 스택에서 제거하고 후위 표기식을 위한 방정식에 넣는다.
                // 현재 연산자보다 우선순위가 높거나 같은 연산자는 계속 스택에서 빼준다.
                while (operators.isNotEmpty() && map["$it"]!! <= map["${operators.peek()}"]!!) {
                    equation.add("${operators.pop()}")
                }
                // 연산자를 스택에 넣는다.
                operators.push(it)
            } else {
                // 연산자가 아닌 경우, 피연산자를 operands 에 누적한다.
                operands.append(it)
            }
        }

        // 처리되지 않은 피연산자를 equation 방정식에 넣어준다.
        equation.add(operands.toString())

        // 연산자 스택에 남아있는 연산자들을 모두 빼서 equation 방정식에 추가한다.
        while (operators.isNotEmpty()) {
            equation.add("${operators.pop()}")
        }

        println("후위 표기식 : $equation")

        val result = Stack<Long>()
        equation.forEach {
            if (map.containsKey(it)) {
                val b = result.pop()
                val a = result.pop()

                result.push(calculate(a, b, it))
            } else {
                result.push(it.toLong())
            }
        }

        println("결과 : ${result.pop()}")
    }

    private fun calculate(a: Long, b: Long, operator: String): Long {
        return when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            else -> a / b
        }
    }

    private fun isOperators(c: Char): Boolean = c == '*' || c == '+' || c == '/' || c == '-'
}