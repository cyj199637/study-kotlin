package assignment.week2

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    if (secret.isNullOrEmpty())
        throw IllegalArgumentException("secret is null or empty.")

    if (guess.isNullOrEmpty())
        throw IllegalArgumentException("guess is null or empty.")

    val leftSecretLetters = secret.toMutableList()
    val leftGuessLetters = guess.toMutableList()

    var rightPosition = 0
    var wrongPosition = 0

    for ((index, letter) in guess.withIndex()) {
        if (letter == secret[index]) {
            rightPosition++
            leftGuessLetters.remove(letter)
            leftSecretLetters.remove(letter)
        }
    }

    for (letter in leftGuessLetters) {
        if (leftSecretLetters.contains(letter)) {
            wrongPosition++
            leftSecretLetters.remove(letter)
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}
