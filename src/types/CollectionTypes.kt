package types

fun main() {
    val mutableList = mutableListOf(1, 2, 3)
    val list: List<Int> = mutableList

    println(list)

    // compile error -> mutating 함수를 사용할 수 없음
//    list.add(3)

    /**
     * 동일한 객체를 할당받은 mutableList 에서 mutating 함수를 사용할 수 있으므로
     * list 의 immutable 이 보장되지 않는다.
     */
    mutableList.add(4)
    println(list)
}