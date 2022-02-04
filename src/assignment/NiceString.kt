package assignment

fun String.isNice(): Boolean {
    val result = mutableListOf<Boolean>()

    // 1.
    result.add(this.withIndex()
        .none {
            (it.value == 'b')
            && (it.index != this.length - 1)
            && ("uae".contains(this[it.index + 1]))
        })

    // 1. another solution
//    result.add(setOf("bu", "ba", "be").any { this.contains(it) })

    // 2.
    result.add(this.count { "aeiou".contains(it) } >= 3)

    // 2. another solution
//    result.add(this.count { it in "aeiou" } >= 3)

    // 3.
    result.add(this.zipWithNext().any { it.first == it.second })

    // 3. another solution
//    result.add(this.windowed(2).any { it[0] == it[1] })

    return result.count { it } >= 2
}