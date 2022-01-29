package controlstructure

fun main() {
    println(isLetter('c'))
    println(isLetter('*'))
    println(isNotLetter('^'))

    println("ball" in "a".."k")
}

fun isLetter(c: Char): Boolean = c in 'a'..'z' || c in 'A'..'Z'

fun isNotLetter(c: Char) = c !in 'a'..'z' && c !in 'A'..'Z'

fun checkChar(c: Char) {
    when (c) {
        in '0'..'9' -> println("It's digit.")
        in 'a'..'z' , in 'A'..'Z' -> println("It's letter.")
        else -> println("What is it?")
    }
}