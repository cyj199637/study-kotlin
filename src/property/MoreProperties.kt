package property

import java.lang.StringBuilder
import kotlin.random.Random

interface User {
    val nickname: String
}

class FacebookUser(val accountId: Int): User {
    override val nickname: String = getFacebookNickname(accountId)

    private fun getFacebookNickname(accountId: Int): String
        = (accountId + Random.nextInt()).toString()
}

class SubscribingUser(val email: String): User {
    override val nickname: String
        get() = email.substringBefore("@")
}

interface Session {
    val user: User
}

fun analyzeUserSession(session: Session) {
    val sessionUser = session.user
    if (sessionUser is FacebookUser) {
        println(sessionUser.accountId)
    }
}

val String.lastIndex: Int
    get() = this.length - 1

val String.indices: IntRange
    get() = 0..this.lastIndex

var StringBuilder.lastChar: Char
    get() = this[this.lastIndex]
    set(new: Char) {
        this[this.lastIndex] = new
    }

fun main(args: Array<String>) {
    println("abcde".lastIndex)
    println("abcde".indices)

    val sb = StringBuilder("abcde")
    println(sb.lastChar)
    sb.lastChar = 'z'
    println(sb)
    println(sb.lastChar)
}