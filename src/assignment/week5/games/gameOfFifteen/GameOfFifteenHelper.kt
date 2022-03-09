package assignment.week5.games.gameOfFifteen

/*
 * This function should return the parity of the permutation.
 * true - the permutation is even
 * false - the permutation is odd
 * https://en.wikipedia.org/wiki/Parity_of_a_permutation

 * If the game of fifteen is started with the wrong parity, you can't get the correct result
 *   (numbers sorted in the right order, empty cell at last).
 * Thus the initial permutation should be correct.
 */
fun isEven(permutation: List<Int>): Boolean {
    val sorted = permutation.sorted()
    val result = permutation.toMutableList()
    var count = 0
    while (result != sorted) {
        for (i in 0..result.size - 2) {
            if (result[i] > result[i+1]) {
                val temp = result[i]
                result[i] = result[i+1]
                result[i+1] = temp
                count++
            }
        }
    }
    return count % 2 == 0
}