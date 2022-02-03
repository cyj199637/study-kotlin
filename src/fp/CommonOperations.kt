package fp

import fp.Gender.*

fun main() {
    val heroes = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE)
    )

    // 1.
    println(heroes.last().name)

    // 2.
    println(heroes.firstOrNull{it.age == 30}?.name)
//    heroes.first{it.age == 30}.name  // NoSuchElementException

    // 3.
    println(heroes.map { it.age }.distinct().size)

    // 4.
    println(heroes.filter { it.age < 30 }.size)

    // 5.
    val (yb, ob) = heroes.partition { it.age < 30 }
    println(ob.size)

    // 6.
    println(heroes.maxByOrNull { it.age }?.name)

    // 7.
    println(heroes.all{ it.age < 50 })

    // 8.
    println(heroes.any { it.gender == FEMALE })

    // 9.
    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxByOrNull { (_, group) -> group.size }!!
    println(age)

    // 10.
    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    println(mapByName["Frenchy"]?.age)

    println(mapByName["unknown"]?.age)  // null
//    println(mapByName.getValue("unknown").age)  // NoSuchElementException

    // 11.
    val mapByName2 = heroes.associate { it.name to it.age }
    println(mapByName2.getOrElse("unknown") { 0 })

    // 12.
    // Bad
    val (first, second) = heroes
        .flatMap { heroes.map { hero -> it to hero } }
        .maxByOrNull { it.first.age - it.second.age }!!
    println(first.name)

    // Good
    val allPossiblePairs = heroes
        .flatMap { first -> heroes.map { second -> first to second } }  // [[(1, 1), (1, 2), ... , (1, 6)], ... , [(6, 1), ... (6, 6)]]
    val (oldest, youngest) = allPossiblePairs
        .maxByOrNull { it.first.age - it.second.age }!!
    println(oldest.name)

    // Best
    val oldestHero = heroes.maxByOrNull { it.age }
    println(oldestHero?.name)
}