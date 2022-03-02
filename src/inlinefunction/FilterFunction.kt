package inlinefunction

/**
 * Write the code that the Kotlin compiler will generate while inlining the filter function (instead of calling it).
 * Note that the compiler generates Java bytecode, but for simplicity, write the similar code in Kotlin.
 * The simplified declaration of 'filter' is given below.
 */

fun filterNonZero(list: List<Int>) = list.filter { it != 0 }

fun filterNonZeroGenerated(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list) {
        if (i != 0) {
            result.add(i)
        }
    }
    return result
}

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)

    println(filterNonZero(list).toString() == "[1, 2, 3]")
    println(filterNonZeroGenerated(list).toString() == "[1, 2, 3]")
}