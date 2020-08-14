package programmers

/**
 * created by victory_woo on 2020/08/14
 * */
class PGM42578kRE {
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
        val map = mutableMapOf<String, Int>()
        for (clothe in clothes) map[clothe[1]] = map.getOrDefault(clothe[1], 0) + 1

        var answer = 1
        for (value in map.values) answer *= (value + 1)
        return answer - 1
    }
}