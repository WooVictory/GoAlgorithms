package programmers

/**
 * created by victory_woo on 2020/08/06
 * */
class PGM42840k {
    fun main(args: Array<String>) {
        solution(intArrayOf(1, 2, 3, 4, 5))
        solution(intArrayOf(1, 3, 2, 4, 2))
    }

    fun solution(answers: IntArray): IntArray {
        val person = arrayOf(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
                intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))
        val list = mutableListOf<Person>()
        var max = 0

        for (i in person.indices) {
            var count = 0
            for (j in answers.indices) {
                // answers 길이가 p1,p2,p3 보다 길어지면, 수포자의 반복되는 답변을 접근하기 위해 나머지 연산을 진행한다.
                val num = j % person[i].size
                if (answers[j] == person[i][num]) count++
            }

            max = Math.max(max, count)
            list.add(Person(i + 1, count))
        }

        return mutableListOf<Int>().apply {
            list.filter { max == it.count }
                    .map { add(it.num) }
        }.toIntArray()
    }

    data class Person(val num: Int, val count: Int)
}