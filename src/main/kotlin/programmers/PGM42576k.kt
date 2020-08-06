package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/06
 * */
class PGM42576k {
    fun main(args: Array<String>) {
        println(solution(arrayOf("leo", "kiki", "eden"), arrayOf("eden", "kiki")))
        println(solution(arrayOf("mislav", "stanko", "mislav", "ana"), arrayOf("stanko", "ana", "mislav")))
    }

    fun solution(participant: Array<String>, completion: Array<String>): String {
        val map = HashMap<String, Int>()
        var answer = ""
        participant.forEach { name -> map[name] = map.getOrDefault(name, 0) + 1 }
        completion.forEach { name -> if (map.containsKey(name)) map[name] = map[name]!! - 1 }

        for ((key, value) in map) {
            if (value > 0) answer = key
        }

        return answer

    }
}