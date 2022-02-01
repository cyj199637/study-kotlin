package assignment

data class EvaluationFP(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuessFP(secret: String, guess: String): EvaluationFP {

    val rightPositions = secret.zip(guess).count { pair -> pair.first == pair.second }

    val commonLetters = "ABCDEF".sumOf { ch ->

        Math.min(secret.count { letter -> ch == letter }, guess.count { letter -> ch == letter })
    }
    return EvaluationFP(rightPositions, commonLetters - rightPositions)
}

fun main(args: Array<String>) {
    val result = EvaluationFP(rightPosition = 1, wrongPosition = 1)
    evaluateGuessFP("BCDF", "ACEB") == result
    evaluateGuessFP("AAAF", "ABCA") == result
    evaluateGuessFP("ABCA", "AAAF") == result
}