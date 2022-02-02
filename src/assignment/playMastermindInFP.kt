package assignment

data class EvaluationFP(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuessFP(secret: String, guess: String): EvaluationFP {

    // zip(): 같은 인덱스에 있는 것끼리 묶어 Pair 객체를 만든 후 list로 반환
    val rightPositions = secret.zip(guess).count { it.first == it.second }

    // 서로 갖고 있지 않은 문자를 제외하기 위함
    val commonLetters = "ABCDEF".sumOf { ch ->
        Math.min(secret.count { ch == it }, guess.count { ch == it })
    }
    return EvaluationFP(rightPositions, commonLetters - rightPositions)
}

fun main(args: Array<String>) {
    val result = EvaluationFP(rightPosition = 1, wrongPosition = 1)
    evaluateGuessFP("BCDF", "ACEB") == result
    evaluateGuessFP("AAAF", "ABCA") == result
    evaluateGuessFP("ABCA", "AAAF") == result
}