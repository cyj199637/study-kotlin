package lambda

fun main() {
    val sb1 = StringBuilder()
    sb1.appendLine("Alphabet: ")
    for (c in 'a'..'z') {
        sb1.append(c)
    }
    println(sb1.toString())

    val sb2 = StringBuilder()
    with(sb2) {
        appendLine("Alphabet: ")
        for (c in 'a'..'z') {
            append(c)
        }
        println(toString())
    }

    val s = buildString {
        for (c in 'a'..'z') {
            append(c)
        }
        println(this)
    }
}