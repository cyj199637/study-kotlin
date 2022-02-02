package nullability

fun main() {
    val s1: String = "Kotlin"
    val s2: String? = null

    println(s1.length)

    // 명시적으로 null 체킹을 하면 safe access expression 없이
    // 역참조를 해도 컴파일 에러가 발생하지 않는다.
    if (s2 != null)
        println(s2.length)

    // ? : safe access expression
    println(s2?.length)

    val length: Int? = s2?.length
    // ?: : elvis expression
    val lengthWithDefault: Int = s2?.length ?: 0

    val x: Int? = 1
    val y = 2
    val sum = x ?: 0 + y    // == x ?: (0 + y)
    println(sum)

    val s3: String? = null
    // !! : not null assertion
    println(s3!!.length)
}

fun isEnabled(s: String?) = s != null

fun actionPerformed(s: String?) = if (isEnabled(s)) s!!.length else 0

fun nullableList(list1: List<Int?>, list2: List<Int>?) {
    println(list1.size)
    println(list2?.size)

    val e1: Int? = list1.get(0)
    // safe access expression을 쓸 경우, 해당 변수가 null 일 때 null을 반환하기 때문에
    // 반환 값을 받는 변수 타입도 nullable 이어야 한다.
    val e2: Int? = list2?.get(0)
}