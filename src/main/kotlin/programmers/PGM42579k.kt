package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/25
 * */
class PGM42579k {
    fun main(args: Array<String>) {
        solution(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500))
    }

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val map = HashMap<String, Int>()
        val list = mutableListOf<Album>()
        for (i in genres.indices) {
            map[genres[i]] = map.getOrDefault(genres[i], 0) + plays[i]
            list.add(Album(i, genres[i], plays[i]))
        }


        val orderedMap = map.toList()
                .sortedByDescending { (_, value) -> value }
                .toMap()

        val result = mutableListOf<Int>()
        for ((key, _) in orderedMap) {
            val subList = list
                    .filter { it.genre == key }
                    .sortedWith(Comparator { o1, o2 ->
                        if (o1.play == o2.play) o1.index - o2.index
                        o2.play - o1.play
                    }).take(2)

            subList.forEach { result.add(it.index) }

        }

        println(result)
        return result.toIntArray()
    }

    data class Album(
            val index: Int,
            val genre: String,
            val play: Int
    )
}