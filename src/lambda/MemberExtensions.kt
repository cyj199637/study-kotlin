package lambda

/**
 * Implement member extension functions 'record' and 'unaryPlus' so that the code below compiled and stored specified words.
 * These functions should be unavailable outside of the 'Words' class.
 */

class Words {
    private val list = mutableListOf<String>()

    fun String.record() {
        list.add(this)
    }

    operator fun String.unaryPlus() {
        record()
    }

    override fun toString() = list.toString()
}

fun main(args: Array<String>) {
    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    println(words.toString() == "[one, two]")
}