package programmers

/**
 * created by victory_woo on 2020/08/05
 * */
class PGM12915k {
    fun main(args: Array<String>) {
        solution2(arrayOf("sun", "bed", "car"), 1)
        solution2(arrayOf("abce", "abcd", "cdx"), 2)
    }

    // o1 - o2 : 오름차순
    // o2 - o1 : 내림차순
    private fun solution(strings: Array<String>, n: Int): Array<String> {
        println(strings.sortedWith(compareBy({ it[n] }, { it })).reversed())
        println(strings.sortedWith(compareBy({ it[n] }, { it })))
        return strings.sortedWith(Comparator { o1, o2 ->
            if (o1[n] == o2[n]) o1.compareTo(o2)
            else o1[n] - o2[n]
        }).toTypedArray()
    }

    private fun solution2(strings: Array<String>, n: Int): Array<String> {
        val result = strings.sortedWith(compareBy({ it[n] }, { it }))
        println(result)
        return result.toTypedArray()
    }
}