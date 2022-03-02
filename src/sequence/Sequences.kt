package sequence

fun main() {
    val result1 = listOf(3, 5, 12, 7, 8)
        .map { it * it }
        .filter { it >= 10 }
        .maxOf { it - 5 }
    println(result1)

    val mid1 = listOf(3, 5, 12, 7, 8)
        .map { it * it }
    println(mid1)

    val mid2 = listOf(3, 5, 12, 7, 8)
        .map { it * it }
        .filter { it >= 10 }
    println(mid2)

    val result2 = listOf(3, 5, 12, 7, 8)
        .asSequence()
        .map { it * it }
        .filter { it >= 10 }
        .maxOf { it - 5 }
    println(result2)

    val mid3 = listOf(3, 5, 12, 7, 8)
        .asSequence()
        .map { it * it }
    println(mid3)

    val mid4 = listOf(3, 5, 12, 7, 8)
        .asSequence()
        .map { it * it }
        .filter { it >= 10 }
    println(mid4)
}