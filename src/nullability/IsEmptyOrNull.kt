package nullability

fun main() {
    val s1: String? = null
    val s2: String? = ""
    println(s1.isEmptyOrNull())
    println(s2.isEmptyOrNull())

    val s3 = "   "
    println(s3.isEmptyOrNull())
}

fun String?.isEmptyOrNull() =
    this == null || this.length == 0