package programmers

/**
 * created by victory_woo on 2020/08/05
 * 두 정수 사이의 합.
 * */

fun main(args: Array<String>) {
    println(solution(3, 6))
    println(solution(3, 3))
    println(solution(5, 3))
}

fun solution(a: Int, b: Int): Long {
    return if (a < b) sum(a, b)
    else sum(b, a)
}

fun sum(a: Int, b: Int): Long {
    return (a.toLong()..b.toLong())
            .sum()
}