package sequence

class Person(val name: String, val age: Int, val isPublicProfile: Boolean)

fun main() {
    val list = (1..5).toList()

    println(list.filter { it < 3 }.size)
    println(list.count { it < 3 })

    println(list.sortedBy { it - 10 }.reversed())
    println(list.sortedByDescending { it - 10 })

    val people = listOf(
        Person("Alice", 23, true),
        Person("Betty", 27, false),
        Person("Chacha", 27, true)
    )

    val result1 = people
        .map { person -> person.takeIf { it.isPublicProfile }?.name }
        .filterNotNull()
    println(result1)
    
    val result2 = people
        .mapNotNull { person -> person.takeIf { it.isPublicProfile }?.name }
    println(result2)

    // ####################################################################

    val result3 = people.filterNotNull().map { it.name }
    println(result3)

    val result4 = people.mapNotNull { it.name }
    println(result4)

    val map1 = mutableMapOf<Int, MutableList<Person>>()
    for (person in people) {
        if (person.age !in map1) {
            map1[person.age] = mutableListOf()
        }
        val group = map1.getValue(person.age)
        group += person
    }
    println(map1)

    val map2 = mutableMapOf<Int, MutableList<Person>>()
    for (person in people) {
        val group = map2.getOrPut(person.age) { mutableListOf() }
        group += person
    }
    println(map2)

    val map3 = people.groupBy { person -> person.age }
    println(map3)

    val result5 = people
        .asSequence()
        .groupBy { person -> person.age }
        .mapValues { (_, values) -> values.size }
    println(result5)

    val result6 = people
        .asSequence()
        .groupingBy { person -> person.age }
        .eachCount()
    println(result6)
}