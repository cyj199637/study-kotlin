package sequence

fun m(i: Int): Int {
    print("map($i)\t")
    return i * 2
}

fun f(i: Int): Boolean {
    print("filter($i)\t")
    return i % 3 == 0
}

fun main() {
    // 1. Collection 은 하나의 연산에 대해 모든 요소들을 대상으로 연산을 수행한다.
    val result1 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .map { m(it) }
        .filter { f(it) }
        .find { it > 10 }
    println(result1)

    // 2. Sequence 는 하나의 요소에 대해 모든 연산을 수행한다.
    //    조건을 만족하는 결과를 찾는다면 이후 연산은 수행하지 않는다.
    val result2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .asSequence()
        .map { m(it) }
        .filter { f(it) }
        .find { it > 10 }
    println(result2)

    // 3. Sequence 는 terminal evaluation 을 수행하기 전까지 연산을 수행하지 않는다.
    val result3 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .asSequence()
        .map { m(it) }
        .filter { f(it) }
    println(result3)

    // 4. 연산의 순서를 적절히 조정하면 연산 횟수를 줄일 수 있다.
    val result4 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .asSequence()
        .filter { f(it) }
        .map { m(it) }
        .find { it > 10 }
    println(result4)
}