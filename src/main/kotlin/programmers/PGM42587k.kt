package programmers

import java.util.*

/**
 * created by victory_woo on 2020/08/13
 * */
class PGM42587k {
    fun main(args: Array<String>) {
        println(solution(intArrayOf(2, 1, 3, 2), 2))
        println(solution(intArrayOf(1, 1, 9, 1, 1, 1), 0))
    }

    // 1) list 2개를 사용했을 때.
    fun solution(priorities: IntArray, location: Int): Int {
        val list = LinkedList<Document>().apply { priorities.forEachIndexed { index, i -> add(Document(index, i)) } }
        val result = LinkedList<Document>()

        while (list.size > 1) {
            val document = list.removeAt(0)
            var flag = true // 인쇄할 수 있는지, 없는지에 대한 flag.
            for (i in 0 until list.size) {
                if (document.priority < list[i].priority) {
                    list.addLast(document) // 프린터 대기열의 뒤에 넣는다.
                    flag = false
                    break
                    // 해당 문서는 바로 인쇄할 수 없으므로 대기열의 뒤에 넣고 빠져나온다.
                }
            }

            // 우선순위가 높아서 인쇄할 수 있다면 result 에 넣는다.
            // result 는 우선순위에 따라서 인쇄한 문서를 순서대로 보관한다.
            if (flag) result.add(document)
        }

        // list 에는 우선순위가 밀려서 대기열의 뒤로 들어간 문서들이 차례대로 쌓여있다.
        // 이를 result 뒤에 붙여준다.
        // 인쇄된 순서대로 문서를 보관한다.
        result.addAll(list)
        println(result)

        var count = 0
        for (i in result.indices) {
            if (result[i].index == location) break
            else count++
        }

        return count + 1
    }

    fun solution2(priorities: IntArray, location: Int): Int {
        // list 에 담는다.
        val list = LinkedList<Document>().apply { priorities.forEachIndexed { index, i -> add(Document(index, i)) } }
        var count = 1
        while (list.size > 1) {
            // 첫 번째 문서를 꺼내온다. 단, 먼저 삭제하지는 않는다.
            val document = list.first
            for (i in list.indices) {
                // 뒤에 있는 문서들 중 꺼낸 문서보다 우선 순위가 높은 문서가 있는지 확인한다.
                if (document.priority < list[i].priority) {
                    // 우선 순위가 높은 문서가 있다면 앞에 있는 문서를 꺼내서 뒤의 대기열에 추가한다.
                    list.addLast(list.removeFirst())
                    break
                }

                // 뒤에 있는 문서를 모두 확인해도, 현재 앞에 있는 문서보다 우선순위가 높은 문서가 없다면
                // 앞에 있는 문서를 인쇄할 수 있다.
                if (i == list.size - 1) {
                    // 단, 인쇄하기 전에 이 문서가 내가 인쇄를 요청한 문서인지 확인해본다.
                    // 맞다면 인쇄를 하지 않고, 해당 문서가 몇번째로 인쇄되는지만 반환한다.
                    if (document.index == location) return count

                    // 요청한 문서가 아니라면 문서를 인쇄하고 몇 번째로 인쇄되었는지 count 를 통해 세어준다.
                    list.removeFirst()
                    count++
                }
            }
        }
        return count
    }

    data class Document(
            val index: Int,
            val priority: Int
    )
}