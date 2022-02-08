package oop

object Factory {
    fun run() {
        println("The Factory is Singleton...")
    }
}

fun registerCustomers(customers: Map<Int, Customer>) {
    registerRepository(object : Repository {
        override fun getById(id: Int): Customer? {
            return customers[id]
        }

        override fun getAll(): List<Customer> {
            return customers.values.toList()
        }
    })
}

fun registerRepository(repository: Repository) {}

interface Element<T> {
    fun create(): T
}

class A private constructor() {
    companion object: Element<A> {
        override fun create(): A {
            return A()
        }

        @JvmStatic fun foo() {
            println("It's Companion Object.")
        }
    }
}

fun <T> createElement(element: Element<T>) = element.create()

fun A.Companion.bar() {
    println("It's Extension Function of Companion Object.")
}

class B {
    object C
}

fun main() {
    Factory.run()

    A.foo()

    createElement(A)
    A.create()

    A.bar()
}