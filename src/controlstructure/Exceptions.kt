package controlstructure

import java.io.IOException
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import kotlin.jvm.Throws

fun main() {
    val number = 101
    val percentage =
        if (number in 0..100)
            number
        else
            throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")

    val value = "String"
    val parsed = try {
        Integer.parseInt(value) // 블록 안의 맨 마지막 문장이 반환 값
    } catch (e: NumberFormatException) {
        null
    }
}

@Throws(IOException::class)
fun parseInt(s: String) = try {
        Integer.parseInt(s)
    } catch (e: NumberFormatException) {
        throw IOException()
    }