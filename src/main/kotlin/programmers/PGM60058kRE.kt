package programmers

/**
 * created by victory_woo on 2020/08/13
 * */
class PGM60058kRE {
    fun main(args: Array<String>) {
        println(solution("(()())()"))
        println(solution(")("))
        println(solution("()))((()"))
    }

    fun solution(p: String): String {
        return solve(p)
    }

    private fun solve(p: String): String {
        // 빈 문자열이라면 빈 문자열을 반환한다.
        if (p.isBlank()) return ""

        // 균형 잡힌 괄호 문자열로 나눌 수 있는 인덱스를 찾는다.
        val index = findBalancedBracketIndex(p)

        // 인덱스가 -1이라면 균형 잡힌 괄호 문자열로 나눌 수 없는 경우를 뜻하므로, 빈 문자열을 반환한다.
        if (index == -1) return ""

        // index 를 활용해 u와 v로 나눈다.
        var u = p.substring(0, index)
        val v = p.substring(index)

        // u가 올바른 괄호 문자열인지 확인한다.
        // 맞다면 -> v에 대해 처음부터 반복하고 이 결과를 u 뒤에 붙여서 반환한다.
        return if (isRightBracket(u)) {
            u + solve(v)
        } else {
            // 아니라면 -> v에 대해 처음부터 반복한 결과 앞, 뒤에 (,)를 붙이고
            // u의 제일 앞과 제일 뒤 문자를 제거한다.
            // 그리고 u의 괄호 방향을 뒤집는다. ( -> )가 되고 ) -> (가 된다.
            // 이렇게 변환된 u를 result 에 붙여서 반환한다.
            val result = '(' + solve(v) + ')'
            u = u.substring(1, u.length - 1)
            u = reverseBracket(u)
            result + u
        }
    }

    // 균형잡힌 괄호 문자열로 분리할 수 있는 인덱스를 찾는다.
    // (,)의 갯수가 동일한 것을 균형잡힌 괄호 문자열이라고 하며,
    // 균형 잡힌 괄호 문자열로 자를 수 있는 가장 작은 인덱스를 찾아 반환한다. 없다면 -1 반환.
    private fun findBalancedBracketIndex(p: String): Int {
        var count = 0
        p.forEachIndexed { index, c ->
            if (c == '(') count++
            else count--

            if (count == 0) return index + 1
        }
        return -1
    }

    // 올바른 괄호 문자열인지 확인한다.
    // 괄호의 갯수가 동일할 뿐 아니라 짝이 맞는지도 확인해야 한다.
    // )이 먼저 나온다면 count 변수가 음수이기 때문에 false 이며
    // count == 0을 만족한다면 올바른 괄호 문자열이기 때문에 true 반환.
    private fun isRightBracket(p: String): Boolean {
        var count = 0
        p.forEach {
            if (it == '(') count++
            else count--

            if (count < 0) return false
        }
        return true
    }

    // 괄호의 방향을 뒤집어서 반환한다.
    private fun reverseBracket(p: String): String {
        return p.map { if (it == '(') ')' else '(' }
                .joinToString("")
    }
}