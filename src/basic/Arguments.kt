package basic

fun main() {
    displaySeparator('#', 5)
    displaySeparator('#')
    displaySeparator()

    displaySeparator(size = 3, character = '&')
    displaySeparator(size = 3)
}

fun argument() {
    println(listOf("a", "b", "c").joinToString(separator = "", prefix = "(", postfix = ")"))
}

@JvmOverloads
fun displaySeparator(character: Char = '*', size: Int = 1) {
    repeat(size) {
        print(character)
    }
    println()
}