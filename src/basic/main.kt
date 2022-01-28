package basic

fun main(args: Array<String>) {
    println("first ${foo()} second ${foo()}")
}

fun foo(): String {
    println("Calculating foo...")
    return "foo"
}