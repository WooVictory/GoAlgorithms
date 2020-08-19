package programmers

/**
 * created by victory_woo on 2020/08/19
 * */
class PGM42888k {
    fun main(args: Array<String>) {
        println(solution(arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan")))
    }

    private val IN_MESSAGE = "들어왔습니다."
    private val OUT_MESSAGE = "나갔습니다."
    fun solution(record: Array<String>): Array<String> {
        val map = hashMapOf<String, String>()
        val result = mutableListOf<Info>()
        for (message in record) {
            val s = message.split(" ")
            when (s[0]) {
                "Enter" -> {
                    map[s[1]] = s[2]
                    result.add(Info(s[1], IN_MESSAGE))
                }
                "Leave" -> {
                    result.add(Info(s[1], OUT_MESSAGE))
                }
                else -> {
                    map[s[1]] = s[2]
                }
            }
        }

        return mutableListOf<String>().apply {
            result.forEach {
                add("${map[it.userId]}님이 ${it.message}")
            }
        }.toTypedArray()
    }

    data class Info(
            val userId: String,
            val message: String
    ) {
        override fun toString(): String {
            return "Info(userId='$userId', message='$message')"
        }
    }
}