package assignment.week5.games.gameOfFifteen

import kotlin.random.Random

interface GameOfFifteenInitializer {
    /*
     * Even permutation of numbers 1..15
     * used to initialized the first 15 cells on a board.
     * The last cell is empty.
     */
    val initialPermutation: List<Int>
}

class RandomGameInitializer : GameOfFifteenInitializer {
    /*
     * Generate a random permutation from 1 to 15.
     * `shuffled()` function might be helpful.
     * If the permutation is not even, make it even (for instance,
     * by swapping two numbers).
     */
    override val initialPermutation by lazy {
        val result = (1..15).shuffled().toMutableList()
        while (!isEven(result)) {
            val randomIndex = Random.nextInt(15)
            val temp = result[randomIndex]
            result[randomIndex] = result[randomIndex+1]
            result[randomIndex+1] = temp
        }
        result
    }
}

