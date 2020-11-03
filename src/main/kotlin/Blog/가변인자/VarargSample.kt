package Blog.가변인자

/**
 * created by victory_woo on 2020/10/27
 * */

fun main(args: Array<String>) {

    val intArr = intArrayOf(1, 2, 3)
    // sum(intArr) error
    sum(*intArr)
    println(sum(1))
    println(sum(1, 2, 3, 4, 5))

    val arr = arrayOf("Lee", "Park")

    // printWoo(arr) error
    printWoo("Lee", "Park")
    printWoo(*arr)

    // 배열에서 생성자를 이용한 초기화 방법.
    val s: Array<Int> = Array(5) { i -> i }


    val array = arrayOf(1, 2, 3)
    asList(array).forEach {
        for (num in it) printWoo("$num ")
        println()
    }

    asList(-1, 0, *array, 4).forEach {
        printWoo("$it ")
    }
    println()
}

fun sum(vararg num: Int) = num.sum()

fun printWoo(vararg s: String) {
    println(s.joinToString("/"))
    println()
}

fun <T> asList(vararg ts: T): List<T> {
    return ArrayList<T>().apply {
        ts.forEach { add(it) }
    }
}