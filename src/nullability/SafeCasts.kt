package nullability

fun main() {
    val any = "Kotlin"

    if (any is String) {
        (any as? String)?.uppercase()
    }

    val s1 = if (any is String) any else null
    val s2 = any as? String

    // playground
    val s = 1.2
    println(s as? Int)    // null
    println(s as Int?)    // exception
}