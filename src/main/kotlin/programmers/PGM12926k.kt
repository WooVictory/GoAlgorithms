package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12926k {
    fun main(args: Array<String>) {
        println(solution("AB", 1))
        println(solution("z", 1))
        println(solution("a B z", 4))
    }

    fun solution(s: String, n: Int): String {
        return buildString {
            s.forEach {
                var c = it
                if (c != ' ') {
                    val start = if (it.isLowerCase()) 'a' else 'A'
                    c = start + ((it + n - start) % 26)
                    // (it+n-start) % 26 => 기준점이 되는 start 로부터 얼만큼 떨어져있는지를 확인할 수 있다.
                }
                append(c)
            }
        }
    }
}