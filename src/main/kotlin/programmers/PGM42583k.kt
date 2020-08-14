package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/14
 * */
class PGM42583k {
    fun main(args: Array<String>) {
        println(solution(2, 10, intArrayOf(7, 4, 5, 6)))
        println(solution(100, 100, intArrayOf(10)))
        println(solution(100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))

    }

    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val waited = LinkedList<Truck>().apply { truck_weights.forEach { add(Truck(it, 0)) } }
        val bridges = LinkedList<Truck>()

        var totalWeight = 0
        var time = 0

        while (waited.isNotEmpty() || bridges.isNotEmpty()) {
            time++ // 시간이 흐른다.

            // 다리에 있는 트럭이 먼저 빠져나가고 다음에 진입한다.
            if (bridges.isNotEmpty()) {
                // 현재 시간에서 트럭이 다리에 진입한 시간을 뺀다.
                // 그러면 현재 시간은 계속 증가한다. 그리고 트럭이 다리를 지날 수 있는지 확인하게 된다.
                if (time - bridges.peekFirst().start_time >= bridge_length) {
                    val truck = bridges.remove()
                    totalWeight -= truck.weight
                }
            }

            if (waited.isNotEmpty()) {
                // 트럭 무게의 합이 다리의 한계치를 초과하지 않는다면
                // 트럭이 다리를 지나갈 수 있게 한다.
                if (totalWeight + waited.peek().weight <= weight) {
                    // 대기하고 있는 곳에서 트럭을 빼고 total 을 증가시킨다.
                    val truck = waited.remove()
                    totalWeight += truck.weight
                    // 이 트럭은 다리를 지나가기 위해 bridges 에 추가한다.
                    bridges.add(Truck(truck.weight, time))
                }
            }
        }

        return time
    }

    data class Truck(
            val weight: Int,
            val start_time: Int
    )


}