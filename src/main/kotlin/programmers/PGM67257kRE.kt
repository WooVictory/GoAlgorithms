package programmers

import java.util.*
import kotlin.collections.HashMap

/**
 * created by victory_woo on 2020/08/25
 * */
class PGM67257kRE {
    fun main(args: Array<String>) {
        //println(solution("100-200*300-500+20"))
        println(solution("50*6-3*2"))
    }

    private val indices = LinkedList<Int>()
    // index 가 들어있음.
    private var answer = -1L
    lateinit var check: BooleanArray
    lateinit var list: List<Char>
    lateinit var exp: String
    fun solution(expression: String): Long {
        exp = expression

        // 1. 문자열에서 연산자를 빼서 list 구성.
        list = expression
                .filter { it.isDigit().not() }
                .toList()
                .distinct()

        val n = list.size
        check = BooleanArray(n)

        // 2. 순열을 활용하여 가능한 모든 경우의 수를 구한다.
        perm(n, n)

        return answer
    }

    private fun perm(N: Int, R: Int) {
        if (indices.size == R) {
            for (i in indices) print(list[i] + " ")
            println()

            // 6. 결과를 반환한다.
            val result = calculate()

            // 7. 최대값을 갱신한다.
            answer = Math.max(answer, result)
            return
        } else {
            for (i in 0 until N) {
                if (!check[i]) {
                    check[i] = true
                    indices.add(i)

                    perm(N, R)
                    check[i] = false
                    indices.removeLast()
                }
            }
        }
    }

    private fun calculate(): Long {
        // 3. 연산자의 우선순위를 정한다.
        val map = HashMap<String, Int>()
        for (i in 0 until indices.size) {
            val index = indices[i]
            val key = "${list[index]}"
            map[key] = i
        }

        // 4. 중위 표기식을 후위 표기식으로 변환한다.
        val operands = StringBuilder()
        val equation = mutableListOf<String>()
        val operators = Stack<String>()

        exp.forEach {
            if (isOperators(it)) {
                equation.add(operands.toString())
                operands.delete(0, operands.length)
                while (operators.isNotEmpty() && map["$it"]!! <= map[operators.peek()]!!) {
                    equation.add(operators.pop())
                }
                operators.push("$it")
            } else {
                operands.append(it)
            }
        }

        // operators 스택에 남아있는 연산자를 빼어 equation 방정식에 추가한다.
        equation.add(operands.toString())
        while (operators.isNotEmpty()) {
            equation.add(operators.pop())
        }

        // 5. 후위 표기법을 계산한다.
        val result = Stack<Long>()
        equation.forEach { e ->
            if (e == "*" || e == "+" || e == "-") {
                val b = result.pop()
                val a = result.pop()
                result.push(getResult(a, b, e))
            } else {
                result.push(e.toLong())
            }
        }

        return Math.abs(result.pop())
    }

    private fun getResult(a: Long, b: Long, operator: String): Long {
        return when (operator) {
            "*" -> a * b
            "+" -> a + b
            else -> a - b
        }
    }

    private fun isOperators(c: Char): Boolean {
        return c == '*' || c == '-' || c == '+'
    }
}