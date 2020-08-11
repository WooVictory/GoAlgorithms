package programmers

/**
 * created by victory_woo on 2020/08/11
 * */
class PGM49993k {
    fun main(args: Array<String>) {
        println(solution("CBD", arrayOf<String>("BACDE", "CBADF", "AECB", "BDA")))
    }

    fun solution(skill: String, skill_trees: Array<String>): Int {
        var count = 0
        skill_trees.forEach { tree ->
            val comp = tree
                    .filter { skill.contains(it) }
                    .map { it }
                    .joinToString("")
            val len = Math.min(skill.length, comp.length)
            var flag = true
            for (i in 0 until len) {
                if (skill[i] != comp[i]) {
                    flag = false
                    break
                }
            }

            if (flag) count++
        }
        return count
    }
}

