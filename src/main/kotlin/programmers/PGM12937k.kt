package programmers

/**
 * created by victory_woo on 2020/08/07
 * */
class PGM12937k {
    fun main(args: Array<String>){
        println(solution(3))
        println(solution(4))
    }

    fun solution(num: Int): String {
        return if (num % 2 == 0) "Even" else "Odd"
    }
}