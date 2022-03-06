package types

import kotlin.test.fail

fun unitTypeFunction() {
    println("It's Unit type.")
}

fun nothingTypeFunction1(): Nothing {
    while (true) {
        println("It's Nothing type.")
    }
}

fun nothingTypeFunction2(): Nothing = TODO("It's Nothing Type")

fun nothingTypeFunction3(): Nothing = throw IllegalArgumentException("It's Nothing Type")

fun nothingTypeFunction4(): Nothing = fail("It's Nothing type")

fun wrongTypeFunction() {
    fail("It's Nothing type")
}


fun main() {
    val unit = unitTypeFunction()
    println(unit)

//    val nothing = nothingTypeFunction2()
//    println(nothing)

    val answer: Any = if (true) {
        42
    } else {
        unitTypeFunction()
    }

    val answer2: Any = if (true) {
        42
    } else {
        wrongTypeFunction()
    }

    val answer3: Int = if (true) {
        42
    } else {
        nothingTypeFunction2()
    }

    // type mismatch error
//    var number1 = null
//    number1 = 42

    var number2: Int? = null
    number2 = 42
}