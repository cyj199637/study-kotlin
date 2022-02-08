package oop

import oop.Month.*

enum class Month(val days: Int) {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31)
}

data class Contact(val name: String, val email: String, val phoneNumber: String) {
    var country: String = "Global"
}

fun main() {
    val currentMonth = FEBRUARY
    when(currentMonth) {
        JANUARY -> println("The end of $currentMonth is ${JANUARY.days}th")
        FEBRUARY -> println("The end of $currentMonth is ${FEBRUARY.days}th")
        MARCH -> println("The end of $currentMonth is ${MARCH.days}th")
        APRIL -> println("The end of $currentMonth is ${APRIL.days}th")
        MAY -> println("The end of $currentMonth is ${MAY.days}th")
        JUNE -> println("The end of $currentMonth is ${JUNE.days}th")
    }

    val contact = Contact("Dean", "dean512@google.com", "01012341234")
    contact.country = "Republic of Korea"
    println(contact)

    val new = contact.copy(phoneNumber = "01012345678")
    println(new)

    val same = contact.copy()
    same.country = "France"
    println(contact == same)
    println(contact === same)
}