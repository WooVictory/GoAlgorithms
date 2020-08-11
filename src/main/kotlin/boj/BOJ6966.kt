package boj

import java.util.*

/**
 * created by victory_woo on 2020/08/11
 * */
class BOJ6966 {
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        var n = sc.nextInt()
        while (n-- > 0) println(solution2(sc.next(), sc.next()))
        /*println(solution("blather", "reblath"))
        println(solution("maryland", "landam"))
        println(solution("bizarre", "brazier"))*/
    }

    fun solution(a: String, b: String): String {
        if (a.length != b.length) return "$a & $b are NOT anagrams."

        val arr1 = a.toCharArray()
        val arr2 = b.toCharArray()
        Arrays.sort(arr1)
        Arrays.sort(arr2)


        val count = arr1.filterIndexed { index, c -> c == arr2[index] }
                .count()

        if (count == arr1.size) {
            println("ANA")
        } else {
            println("NOT")
        }
        var flag = true
        for (i in arr1.indices) {
            if (arr1[i] != arr2[i]) {
                flag = false
                break
            }
        }

        return if (flag) "$a & $b are anagrams."
        else "$a & $b are NOT anagrams."
    }

    fun solution2(a: String, b: String): String {
        if (a.length != b.length) return "$a & $b are NOT anagrams."

        val arr1 = a.toCharArray()
        val arr2 = b.toCharArray()
        Arrays.sort(arr1)
        Arrays.sort(arr2)


        val count = arr1.filterIndexed { index, c -> c == arr2[index] }
                .count()

        return if (count == arr1.size) "$a & $b are anagrams."
        else "$a & $b are NOT anagrams."
    }
}