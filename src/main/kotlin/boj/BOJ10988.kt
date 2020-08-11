package boj

import java.util.*

/**
 * created by victory_woo on 2020/08/11
 * */
class BOJ10988 {
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        println(solution(sc.next()))
    }

    fun solution(word: String): Int {
        var size = word.length - 1
        var flag = true
        for (i in 0 until word.length) {
            if (word[i] != word[size--]) {
                flag = false
                break
            }
        }

        return if (flag) 1 else 0
    }

    fun solution2(word: String): Int {
        return if (word == word.reversed()) 1 else 0
    }
}