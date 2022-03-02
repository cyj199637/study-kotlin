package sequence

fun fibonacci(): Sequence<Int> = sequence {
    var first = 0
    var second = 1
    yield(first)
    yield(second)
    while (true) {
        val current = first + second
        yield(current)
        first = second
        second = current
    }
}

fun fibonacciAnswer(): Sequence<Int> = sequence {
    var element = Pair(0, 1)
    while (true) {
        yield(element.first)
        element = Pair(element.second, element.first + element.second)
    }
}

fun main() {
    println(fibonacciAnswer().take(4).toList().toString() ==
            "[0, 1, 1, 2]")

    println(fibonacciAnswer().take(10).toList().toString() ==
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]")
}