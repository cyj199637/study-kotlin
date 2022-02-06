package property

val hello1: String = run {
    println("It's the first access.")
    "Hello"
}

val hello2: String by lazy {
    println("It's the first access.")
    "Hello"
}

class Foo {
    lateinit var bar: String

    fun initialize() {
        println("Bar will be initialized here")
        bar = "Bar"
    }

    fun lowercaseBar() {
        if (this::bar.isInitialized) {
            println(bar.lowercase())
        }
    }
}

fun main() {
    println("Start")

    println(hello1)
    println(hello1)

    println("####################")

    println(hello2)
    println(hello2)

    println("End")

    val foo = Foo()
    foo.initialize()
    foo.bar.length

    foo.lowercaseBar()
}