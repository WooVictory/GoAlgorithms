package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/14
 * */
class PGM42587kRE {
    fun main(args: Array<String>) {
        println(solution(intArrayOf(2,1,3,2),2))
    }

    fun solution(priorities: IntArray, location: Int): Int {
        // 우선순위에 따라 문서를 대기열에 넣는다.
        val list = LinkedList<Document>()
                .apply { priorities.forEachIndexed { index, i -> add(Document(index, i)) } }
        var answer = 1
        // 인쇄 순서.


        // 새로운 프린터의 동작을 실제로 구현한다.
        while (list.size > 1) {
            // 가장 앞에 있는 문서를 대기열에서 꺼낸다.
            val document = list[0]

            // 대기열에 있는 나머지 문서들과 비교하여 첫 번째 문서보다 우선순위가 높은 문서가 있는지 확인한다.
            for (i in list.indices) {
                // 대기열에 있는 문서가 앞에서 뽑은 문서보다 우선순위가 높다면
                // 앞에서 뽑은 문서를 대기열의 가장 뒤에 넣는다.
                if (document.priority < list[i].priority) {
                    list.addLast(list.removeFirst())
                    break
                }

                // 여기까지 왔다는 것은 앞에 있는 문서가 대기열에 있는 문서보다 우선순위가 높다는 것을 뜻한다.
                // 따라서 인쇄를 진행한다.
                if (i == list.lastIndex) {
                    // 인쇄를 진행하기 전에 인쇄를 할 문서가 내가 요청한 문서와 같은지 확인한다.
                    // 같다면 해당 문서의 인쇄 순서를 반환한다.
                    if (document.index == location) return answer

                    list.removeFirst() // 인쇄를 한다.
                    answer++ // 인쇄 순서를 증가시킨다.
                }
            }
        }
        return answer
    }

    data class Document(val index: Int,
                        val priority: Int)
}