package oop

sealed class Expr

class Num(val value: Int): Expr()

class Sum(val left: Expr, val right: Expr): Expr()

fun eval(e: Expr): Int = when(e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
}

class Foo {
    val name: String = "Foo"

    // Nested class(default)
    class Bar {
        val name: String = "Bar"
    }
    // Inner class
    inner class Baz {
        val name: String = "Baz"

        init {
            // access Outer class
            println(this@Foo.name)
        }
    }
}

class Customer

interface Repository {
    fun getById(id: Int): Customer?
    fun getAll(): List<Customer>
}

interface Logger {
    fun logAll()
}

class Controller(
    val repository: Repository,
    val logger: Logger
): Repository by repository, Logger by logger

fun use(controller: Controller) {
    controller.getById(100)
    controller.getAll()
    controller.logAll()
}

fun main() {
    println(eval(Sum(Num(1), Sum(Num(2), Num(3)))))

    println(Foo().name)
    println(Foo.Bar().name)
    println(Foo().Baz().name)
}