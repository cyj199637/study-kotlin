package oop

import java.lang.Appendable

fun <T: Any> upperbound(list: List<T>) = list.forEach { println(it) }

fun <T: Number> half(n: T): Double = n.toDouble() / 2.0

fun <T: Number?> half(n: T): Double? {
    if (n == null) return null
    return n.toDouble() / 2.0
}

fun <T: Int> quarter(n: T): Double = n.toDouble() / 4.0

@JvmName("doubleQuarter")
fun <T: Double> quarter(n: T): Double = n / 4.0

fun <T> ensureTrailingPeriod(seq: T) where T: CharSequence, T: Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

fun main() {
    val list = listOf(1, 2, 3)
    val nullable = listOf(null, 2, 3)

    println(upperbound(list))
//    println(upperbound(nullable))  // compile error

    println(half(15))
//    println(half(null))    // compile error
//    println(half("abc"))   // compile error

    println(half(15))
    println(half(null))

    val sb = StringBuilder("It's test for where keyword")
    ensureTrailingPeriod(sb)
    println(sb)

    println(quarter(1))
    println(quarter(1.0))
}