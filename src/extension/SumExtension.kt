package extension

fun List<Int>.sum(): Int = this.stream().reduce(0, Int::plus)

fun main(args: Array<String>) {
    val sum = listOf(1, 2, 3).sum()
    println(sum)    // 6
}