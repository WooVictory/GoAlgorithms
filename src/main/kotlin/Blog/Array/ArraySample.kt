package Blog.Array

/**
 * created by victory_woo on 2020/10/28
 * */

fun main(args: Array<String>) {
    initTest()
    initWithConstructor()
}

private fun initTest() {
    val array: Array<Int> = arrayOf(1, 2, 3)
    val array2 = arrayOfNulls<Int>(3)

    array.forEach { print("$it ") }
    println()
    array2.forEach { print("$it ") }
    println()
}

private fun initWithConstructor() {
    val array: Array<Int> = Array(3) { i -> i * i }

    array.forEach { print("$it ") }
    println()
}