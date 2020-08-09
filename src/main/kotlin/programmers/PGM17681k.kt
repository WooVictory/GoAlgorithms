package programmers

/**
 * created by victory_woo on 2020/08/09
 * */
class PGM17681k {
    fun main(args: Array<String>) {
        //solution(5, intArrayOf(9, 20, 28, 18, 11), intArrayOf(30, 1, 21, 17, 28))
        solution(6, intArrayOf(46, 33, 33, 22, 31, 50), intArrayOf(27, 56, 19, 14, 14, 10))
    }

    fun solution(n: Int, arr1: IntArray, arr2: IntArray): Array<String> {
        val map1 = convert(n, arr1)
        val map2 = convert(n, arr2)

        return mutableListOf<String>().apply {
            var sb: StringBuilder
            for (i in map1.indices) {
                sb = StringBuilder()
                for (j in map1[i].indices) {
                    if (map1[i][j] == '1' || map2[i][j] == '1') sb.append("#")
                    if (map1[i][j] == '0' && map2[i][j] == '0') sb.append(' ')
                }

                add(sb.toString())
            }
        }.toTypedArray()
    }

    private fun convert(n: Int, arr: IntArray): Array<String> {
        return arr.map {
            var value = Integer.toBinaryString(it)
            while (value.length < n) value = "0$value"
            value
        }.toTypedArray()
    }
}