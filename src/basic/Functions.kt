@file:JvmName("Util")
package basic

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// function with expression body
fun max2(a: Int, b: Int): Int = if (a > b) a else b

fun displayMax(a: Int, b: Int) {
    println(max(a, b))
}

fun displayMax2(a: Int, b: Int): Unit {
    println(max(a, b))
}

fun topLevel() = 1

class A {
    fun classLevel() = 2
}

fun other() {
    fun localLevel() = 3
}