package programmers

/**
 * created by victory_woo on 2020/08/25
 * */
class PGM42579kRE {
    fun main(args: Array<String>) {
        solution(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500))
    }

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices
                .groupBy { genres[it] }
                .toList()
                .sortedByDescending { pair -> pair.second.sumBy { plays[it] } }
                .map { it.second.sortedByDescending { plays[it] }.take(2) }
                .flatten()
                .toIntArray()
    }
}