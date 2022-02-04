package fp

class Person(val name: String, val age: Int) {
    fun isOrder(ageLimit: Int) = age > ageLimit

    fun getAgePredicate() = ::isOrder
}

fun isEven(i: Int) = i % 2 == 0

fun main() {
    val people = listOf(
        Person("A", 29),
        Person("B", 55),
        Person("C", 37),
        Person("D", 9),
        Person("E", 20)
    )

    people.maxByOrNull { it.age }
    people.maxByOrNull(Person::age)

    val isOdd = {i: Int -> i % 2 != 0}
//    val predicate = isEven  // compile error
    val predicate = ::isEven
    val predicateWithLambda = { i: Int -> isEven(i) }

    // Non-Bound Reference
    val agePredicateNBR = Person::isOrder
    val agePredicateNBRLambda = {person: Person, ageLimit: Int -> person.isOrder(ageLimit)}
    val alice = Person("Alice", 29)
    agePredicateNBR(alice, 40)

    // Bound Reference
    val bob = Person("Bob", 55)
    val agePredicateBR = bob::isOrder
    val agePredicateBRLambda = { ageLimit:Int -> bob.isOrder(ageLimit) }
    agePredicateBR(40)
}