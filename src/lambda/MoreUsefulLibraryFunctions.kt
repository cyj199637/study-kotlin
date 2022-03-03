package lambda

data class Person(val name: String, var age: Int, var address: String?) {
    var isPublicProfile = true
}

fun main() {
    val person = Person("Daisy", 32, "New York")
    with(person) {
        println("with with(): ")
        print("$name\t")
        print("$age\t")
        print("$address\t")
    }

    println()

    person.run {
        println("with run(): ")
        print("$name\t")
        print("$age\t")
        print("$address\t")
    }

    println()

    val person2 = Person("Emily", 19, "LA")
        .apply {
            isPublicProfile = false
        }
    println(person2)

    val person3 = Person("Flora", 26, "California")
        .also {
            requireNotNull(it.address)
        }

    person3.let {
        println("with let()")
        println(it)
    }
}