package convention

data class Person(val name: String, val age: Int, val address: String): Comparable<Person> {
    override operator fun compareTo(other: Person): Int = this.age - other.age
}

fun main() {
    val a = Person("Alice", 23, "New York")
    val b = Person("Betty", 31, "LA")
    println(a > b)

    val c = Person("Chacha", 27, "California")
    println(c in a..b)
}