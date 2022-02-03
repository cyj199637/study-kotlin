package fp

fun main() {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val sum2: ((Int, Int) -> Int)? = null
//    val sum3: ((Int, Int) -> Int)? = { null }   // compile error
//    val sum4: ((Int, Int) -> Int?) = null   // compile error
    val sum5: ((Int, Int) -> Int?) = { null }
    val sum6 = { x: Int, y: Int -> x + y }  // 타입 추론

    val result = sum(2, 3)
}