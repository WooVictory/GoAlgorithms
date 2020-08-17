package programmers

/**
 * created by victory_woo on 2020/08/17
 * */
class PGM64065k {
    fun main(args: Array<String>) {
        println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))
        println(solution("{{20,111},{111}}"))
    }

    fun solution(s: String): IntArray {
        val map = mutableMapOf<String, Int>()
        val pattern = s.substring(1, s.length - 1)
        var size = pattern.filter { it == '{' }.count()
        var start = 0
        var end: Int
        while (size-- > 0) {
            start = pattern.indexOf('{', start)
            end = pattern.indexOf('}', start)

            countNumber(map, pattern.substring(start + 1, end).split(","))

            start = end
        }

        val list = mutableListOf<Tuple>().apply { map.forEach { add(Tuple(it.key, it.value)) } }
        list.sortByDescending { it.count }
        return list.map { (it.number).toInt() }
                .toIntArray()
    }

    private fun countNumber(map: MutableMap<String, Int>, numbers: List<String>) {
        numbers.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
    }

    data class Tuple(val number: String, val count: Int) {
        override fun toString(): String {
            return "Tuple(number='$number', count=$count)"
        }
    }
}