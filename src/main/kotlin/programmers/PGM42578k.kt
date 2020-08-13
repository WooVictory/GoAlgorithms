package programmers

/**
 * created by victory_woo on 2020/08/13
 * */
class PGM42578k {
    fun main(args: Array<String>) {
        println(solution(arrayOf(
                arrayOf("yellow_hat", "headgear"),
                arrayOf("blue_sunglasses", "eyewear"),
                arrayOf("green_turban", "headgear")
        )))

        println(solution(arrayOf(
                arrayOf("crow_mask", "face"),
                arrayOf("blue_sunglasses", "face"),
                arrayOf("smoky_makeup", "face")
        )))
    }

    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map = mutableMapOf<String, Int>()
        for (cloth in clothes) {
            map[cloth[1]] = map.getOrDefault(cloth[1], 0) + 1
        }
        for (value in map.values) answer *= (value + 1)
        return answer - 1
    }
}