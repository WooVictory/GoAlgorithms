package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/24
 * */
class PGM67257k {
    fun main(args: Array<String>) {
        //println(solution("100-200*300-500+20"))
        println(solution("50*6-3*2"))
    }

    val list = LinkedList<Int>()
    lateinit var check: BooleanArray
    lateinit var operations: List<Char>
    lateinit var exp: String
    private var answer = -1L
    fun solution(expression: String): Long {
        exp = expression
        // 1. 연산자만 뽑아서 set 에 저장.
        operations = expression
                .filter { it.isDigit().not() }
                .toMutableList()
                .distinct()
        val n = operations.size
        check = BooleanArray(n)

        // 2. 순열을 통해 가능한 경우의 수를 모두 구해본다.
        perm(n, n)
        return answer
    }

    private fun perm(N: Int, R: Int) {
        if (list.size == R) {
            // 3. 연산자 우선순위를 정했고, 계산을 해야 함!!
            //for (i in list) print(operations[i] + ", ")
            val ret = calculate()
            answer = Math.max(answer, ret)
            return
            //println()
        } else {
            for (i in 0 until N) {
                if (!check[i]) {
                    check[i] = true
                    list.add(i)

                    perm(N, R)
                    check[i] = false
                    list.removeLast()
                }
            }
        }
    }

    private fun calculate(): Long {
        val map = mutableMapOf<String, Int>()
        for (i in 0 until list.size) {
            val index = list[i]
            map["${operations[index]}"] = i
        }

        //println(map)

        val sb = StringBuilder()
        val equation = mutableListOf<String>()
        val arg = Stack<String>()

        exp.forEach {
            if (it == '+' || it == '-' || it == '*') {
                equation.add(sb.toString())
                sb.delete(0, sb.length)
                while (arg.isNotEmpty() && map["$it"]!! <= map[arg.peek()]!!) {
                    equation.add(arg.pop())
                }
                arg.push("$it")
            } else {
                sb.append(it)
            }
        }
        equation.add(sb.toString())
        while (arg.isNotEmpty()) {
            equation.add(arg.pop())
        }

        //println(equation)

        val value = Stack<Long>()
        for (e in equation) {
            if (map.containsKey(e)) {
                val b = value.pop()
                val a = value.pop()

                if (e == "+") value.push(a + b)
                if (e == "-") value.push(a - b)
                if (e == "*") value.push(a * b)
            } else {
                value.push(e.toLong())
            }
        }

        return Math.abs(value.pop())
    }
}