package programmers

/**
 * created by victory_woo on 2020/08/12
 * */
class PGM60058k {
    fun main(args: Array<String>) {
        println(solution("(()())()"))
        // expected : (()())()
        // actual : (()())()

        println(solution(")("))
        // expected : ()
        // actual : ()

        println(solution("()))((()"))
        // expected : ()(())()
        // actual : ()(())()
    }

    // 실수한 부분 : blank 체크하는 부분이 solution 함수에 있었는데,
    // getSolution()으로 이동했다. 왜냐하면, 재귀호출하면서 빈 문자열이 나올 수 있기 때문에 getSolution() 안으로 옮겼다.
    fun solution(p: String): String {
        return getSolution(p)
    }

    private fun getSolution(p: String): String {
        if (p.isBlank()) return ""

        val index = split(p)
        if (index == -1) return ""

        val u = p.substring(0, index)
        val v = p.substring(index)
        return if (isRightBracket(u)) {
            u + getSolution(v)
        } else {
            val result = "(" + getSolution(v) + ")"
            val convertedU = reverse(u.substring(1, u.length - 1))
            result + convertedU
        }
    }

    private fun reverse(s: String): String {
        return buildString {
            s.forEach {
                if (it == '(') append(')')
                else append('(')
            }
        }
    }

    // 균형잡힌 괄호문자열로 분리할 수 있는 인덱스를 찾아 반환한다.
    // 없다면 -1을 반환한다.
    private fun split(p: String): Int {
        var count = 0
        for (i in p.indices) {
            if (p[i] == '(') count++
            else count--

            if (count == 0) {
                return (i + 1)
            }
        }

        return -1
    }

    // 올바른 괄호 문자열인지 판단.
    private fun isRightBracket(u: String): Boolean {
        var count = 0
        for (i in u.indices) {
            if (u[i] == '(') count++
            else count--

            if (count < 0) return false
        }

        return count == 0
    }
}