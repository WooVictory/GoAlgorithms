package programmers

/**
 * created by victory_woo on 2020/08/12
 * */
class PGM49993kRE {
    fun main(args: Array<String>) {
        println(solution("CBD", arrayOf("BACDE", "CBADF", "AECB", "BDA")))
    }

    fun solution(skill: String, skill_trees: Array<String>): Int {
        var count = 0
        for (tree in skill_trees) {
            val comp = tree
                    .filter { skill.contains(it) }
                    .toList()
                    .joinToString("")
            val min = Math.min(skill.length, comp.length)
            var flag = true
            for (j in 0 until min) {
                if (skill[j] != comp[j]) {
                    flag = false
                    break
                }
            }

            if (flag) count++
        }
        return count
    }
}