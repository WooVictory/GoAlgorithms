package Sample

/**
 * created by victory_woo on 2020/08/18
 * */
class FibonacciSample {
    fun main(args: Array<String>) {
        println(fibonacciWithRecursive(10, 0, 1))
    }

    private fun fibonacciLoop(n: Int): Int {
        var first = 1
        var second = 1
        return when (n) {
            1 -> first
            2 -> second
            else -> {
                var current = first + second
                for (i in 3..n) {
                    current = first + second
                    first = second
                    second = current
                }

                current
            }
        }
    }

    private tailrec fun fibonacciWithRecursive(n: Int, first: Int, second: Int): Int {
        return if (n <= 0) first
        else fibonacciWithRecursive(n - 1, second, first + second)
    }
}