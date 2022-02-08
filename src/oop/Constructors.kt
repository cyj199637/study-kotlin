package oop

class Person
    internal constructor(val name: String, var age: Int) {

    internal constructor(name: String): this(name, 0)
}

open class Animal(val name: String) {
    open val sound: String = "?????"

    init {
        println(sound)
    }
}

class Cat(name: String, var age: Int): Animal(name) {
    override val sound: String = "Meow"

    constructor(name:String, birthYear: Int, currentYear: Int): this(name, currentYear - birthYear)
}

interface Shape

class Rectangle(x: Int, y: Int): Shape {
    val x: Int
    val y: Int
    val area: Int

    init {
        this.x = x
        this.y = y
        this.area = x * y
    }
}

fun main() {
    Cat("ChaCha", 1)
    Cat("ChaCha", 2020, 2022)
}