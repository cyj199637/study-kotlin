package assignment

import kotlin.math.min

data class EvaluationInFP(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuessInFP(secret: String, guess: String): EvaluationInFP {
    if (secret.isNullOrEmpty())
        throw IllegalArgumentException("secret is null or empty.")

    if (guess.isNullOrEmpty())
        throw IllegalArgumentException("guess is null or empty.")

    val leftSecretLetters = secret.toMutableList()
    val leftGuessLetters = guess.toMutableList()

    var rightPosition = 0
    var wrongPosition = 0

    guess.withIndex().forEach {
        if (it.value == secret[it.index]) {
            rightPosition++
            leftGuessLetters.remove(it.value)
            leftSecretLetters.remove(it.value)
        }
    }

    leftGuessLetters.forEach {
        if (leftSecretLetters.contains(it)) {
            wrongPosition++
            leftSecretLetters.remove(it)
        }
    }

    return EvaluationInFP(rightPosition, wrongPosition)
}

fun evaluateGuessInFPWithRefactoring(secret: String, guess: String): EvaluationInFP {
    val alphabats = listOf('A', 'B', 'C', 'D', 'E', 'F')

    val rightPosition = secret.zip(guess)
        .count { it.first == it.second }

    val countForSecret = alphabats.map { alphabat -> secret.count { letter -> letter == alphabat } }
    val countForGuess = alphabats.map { alphabat -> guess.count { letter -> letter == alphabat } }

    val commonCount = (0 until alphabats.size).sumOf {
        min(countForSecret[it], countForGuess[it])
    }

    return EvaluationInFP(rightPosition, commonCount - rightPosition)
}

fun main(args: Array<String>) {
    val result = EvaluationInFP(rightPosition = 1, wrongPosition = 1)
    println(evaluateGuessInFPWithRefactoring("BCDF", "ACEB") == result)
    println(evaluateGuessInFPWithRefactoring("AAAF", "ABCA") == result)
    println(evaluateGuessInFPWithRefactoring("ABCA", "AAAF") == result)
}