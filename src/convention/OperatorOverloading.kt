package convention

data class Point(val x: Int, val y: Int)

operator fun Point.plus(other: Point) =
    Point(x + other.x, y + other.y)

operator fun Point.minus(other: Point) =
    Point(x - other.x, y - other.y)

operator fun Point.times(scale: Int) =
    Point(x * scale, y * scale)

operator fun Point.unaryPlus() = Point(+x, +y)

operator fun Point.unaryMinus() = Point(-x, -y)

//operator fun <E> MutableCollection<E>.plusAssign(other: E) {
//    add(other)
//}

fun main() {
    var a = Point(1, 3)
    val b = Point(2, 5)
    println(a + b)
    println(a - b)
    println(a * 3)

    println(-a)
    println(+a)

    a += (b)
    println(a)

    a -= b
    println(a)

    a *= 2
    println(a)

    var list1 = listOf(1, 2, 3)
    val list2 = list1
    list1 += 4
    println(list1)
    println(list2)

    val list3 = mutableListOf(1, 2, 3)
    val list4 = list3
    list3 += 4
    println(list3)
    println(list4)
}