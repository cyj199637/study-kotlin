package oop

val answer1 = 42    // Constants.getAnswer1() in Java
const val answer2 = 42  // Constants.answer2 in Java
@JvmField
val answer3 = 42    // Constants.answer3 in Java

class SweetCoffee {
    @JvmField
    val taste = "SWEET"    // regular field generated
}

object BitterCoffee {
    const val taste1 = "BITTER"    // BitterCoffee.taste1 in Java

    @JvmField
    val taste2 = "BITTER"    // static field generated
                             // BitterCoffee.taste2 in Java

    @JvmStatic
    val taste3 = "BITTER"   // BitterCoffee.getTaste2() in Java
}

fun main() {

}