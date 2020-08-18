package Sample

/**
 * created by victory_woo on 2020/08/18
 * */
class FactorialSample {
    fun main(args: Array<String>) {
        println(factorial(3, 1))
    }

    private fun factorial(n: Int, acc: Int): Int {
        return if (n <= 0) acc
        else factorial(n - 1, n * acc)
    }

//    private tailrec fun factorial_plus_n(n: Int, acc: Int): Int {
//        return if (n <= 0) acc
//        else 1 + factorial_plus_n(n - 1, n * acc)
//    }
}