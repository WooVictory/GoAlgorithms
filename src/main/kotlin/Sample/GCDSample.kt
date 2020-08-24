package Sample

/**
 * created by victory_woo on 2020/08/24
 * */
class GCDSample {
    fun main(args: Array<String>) {
        val (a, b) = readLine()!!.split(" ").map(String::toInt)
        println(getGcd(a, b))
    }

    private fun getGcd(x: Int, y: Int): String {
        var a = x
        var b = y
        var r = a % b
        while (r != 0) {
            a = b
            b = r
            r = a % b
        }
        return "최대 공약수 : $b, 최소 공배수 : ${x * y / b}"
    }
}