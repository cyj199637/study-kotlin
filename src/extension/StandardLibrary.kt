package extension

fun main() {
    val set = setOf(1, 2, 3)
    val list = listOf(1, 2, 3)
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")

    // set.javaClass ≒ set.getClass() in Java
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println(listOf('a', 'b', 'c').joinToString())

    println("12.345-6.A".split("""\.|-""".toRegex()))
    println("12.345-6.A".split("."))
    println("12.345-6.A".split("-","."))
}