package extension

fun main() {
    val c = "Happy Bear".lastChar();
    println(c)

    val cat = Cat("ChunBae")
    val lastChatOfName = cat.getName().lastChar()
    println(lastChatOfName)

    println("abc".getStar(1))

    val cat2: Animal = Cat("Nabi")
    cat2.talk()
}

// String -> 작성된 확장 함수의 Receiver
fun String.lastChar() = get(length - 1)

fun String.getStar(index: Int) = "*"

fun Animal.talk() {
    println("myang")
}

fun Cat.talk() {
    println("meow")
}