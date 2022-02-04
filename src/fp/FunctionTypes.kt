package fp

fun main() {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val sum2: ((Int, Int) -> Int)? = null
//    val sum3: ((Int, Int) -> Int)? = { null }   // compile error
//    val sum4: ((Int, Int) -> Int?) = null   // compile error
    val sum5: ((Int, Int) -> Int?) = { _, _ -> null }
    val sum6 = { x: Int, y: Int -> x + y }  // 타입 추론

    val result = sum(2, 3)

    if (sum2 != null)
        sum2(2, 3)

    sum2?.invoke(2, 3)

    val isEven = {i: Int -> i % 2 == 0}

    val list = listOf(1, 2, 3, 4, 5)
    list.any(isEven)
    list.filter(isEven).forEach { println(it) };

    // Call Lambda Directly
    // Bad
    { println("Russ Bear") }()
    // Good
    run { println("Russ Bear") }
}