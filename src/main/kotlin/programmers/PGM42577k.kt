package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/12
 * */
class PGM42577k {
    fun main(args: Array<String>) {
        println(solution(arrayOf("119", "97674223", "1195524421")))
        println(solution(arrayOf("12", "123", "1235", "567", "88")))
        println(solution(arrayOf("123", "456", "789")))
    }

    fun solution(phone_book: Array<String>): Boolean {
        Arrays.sort(phone_book)
        for (i in phone_book.indices) {
            val phone = phone_book[i]
            for (j in (i + 1) until phone_book.size) {
                if (phone_book[j].startsWith(phone)) return false
            }
        }
        return true
    }
}