package controlstructure

fun main() {
    val map = mapOf(1 to "a",
                    2 to "b",
                    3 to "c")
    for ((key, value) in map) {
        println("$key, $value")
    }

    val list = listOf('a', 'b', 'c')
    for ((index, char) in list.withIndex()) {
        println("$index : $char")
    }

    for (i in 0..9) {
        print(i)
    }
    println()

    for (i in 0 until 9) {
        print(i)
    }
    println()

    for (i in 9 downTo 0 step 2) {
        print(i)
    }
    println()

    for (char in "abc") {
        print(char + 1)
    }
}