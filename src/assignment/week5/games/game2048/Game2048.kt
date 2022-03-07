package games.game2048

import board.Cell
import board.Direction
import board.GameBoard
import board.createGameBoard
import games.game.Game

/*
 * Your task is to implement the game 2048 https://en.wikipedia.org/wiki/2048_(video_game).
 * Implement the utility methods below.
 *
 * After implementing it you can try to play the game running 'PlayGame2048'.
 */
fun newGame2048(initializer: Game2048Initializer<Int> = RandomGame2048Initializer): Game =
        Game2048(initializer)

class Game2048(private val initializer: Game2048Initializer<Int>) : Game {
    private val board = createGameBoard<Int?>(4)

    override fun initialize() {
        repeat(2) {
            board.addNewValue(initializer)
        }
    }

    override fun canMove() = board.any { it == null }

    override fun hasWon() = board.any { it == 2048 }

    override fun processMove(direction: Direction) {
        if (board.moveValues(direction)) {
            board.addNewValue(initializer)
        }
    }

    override fun get(i: Int, j: Int): Int? = board.run { get(getCell(i, j)) }
}

/*
 * Add a new value produced by 'initializer' to a specified cell in a board.
 */
fun GameBoard<Int?>.addNewValue(initializer: Game2048Initializer<Int>) {
    val new = initializer.nextValue(this)
    if (new != null) {
        this[new.first] = new.second
    }
}

/*
 * Update the values stored in a board,
 * so that the values were "moved" in a specified rowOrColumn only.
 * Use the helper function 'moveAndMergeEqual' (in Game2048Helper.kt).
 * The values should be moved to the beginning of the row (or column),
 * in the same manner as in the function 'moveAndMergeEqual'.
 * Return 'true' if the values were moved and 'false' otherwise.
 */
fun GameBoard<Int?>.moveValuesInRowOrColumn(rowOrColumn: List<Cell>): Boolean {
    val original = rowOrColumn.map { cell -> this[cell] }
    val result = original.moveAndMergeEqual { it.times(2) }
    for (i in rowOrColumn.indices) {
        if (i >= result.size) {
            this[rowOrColumn[i]] = null
            continue
        }
        this[rowOrColumn[i]] = result[i]
    }
    if (original.all { it == null } && result.isEmpty()) {
        return false
    }
    return original != result
}

/*
 * Update the values stored in a board,
 * so that the values were "moved" to the specified direction
 * following the rules of the 2048 game .
 * Use the 'moveValuesInRowOrColumn' function above.
 * Return 'true' if the values were moved and 'false' otherwise.
 */
fun GameBoard<Int?>.moveValues(direction: Direction): Boolean {
    val rowOrColumns: List<List<Cell>> = when (direction) {
        Direction.UP, Direction.DOWN -> getColumns(direction)
        Direction.LEFT, Direction.RIGHT -> getRows(direction)
    }
    val result = mutableListOf<Boolean>()

    for (line in rowOrColumns) {
        result.add(moveValuesInRowOrColumn(line))
    }
    return result.any { it }
}

private fun GameBoard<Int?>.getColumns(direction: Direction): List<List<Cell>> {
    val result: MutableList<List<Cell>> = mutableListOf()
    val width = this.width
    val iRange = 1..width
    val iRangeAsReversed = width downTo 1
    for (j in 1..width) {
        when (direction) {
            Direction.UP -> result.add(this.getColumn(iRange, j))
            Direction.DOWN -> result.add(this.getColumn(iRangeAsReversed, j))
        }
    }
    return result
}

private fun GameBoard<Int?>.getRows(direction: Direction): List<List<Cell>> {
    val result: MutableList<List<Cell>> = mutableListOf()
    val width = this.width
    val jRange = 1..width
    val jRangeAsReversed = width downTo 1
    for (i in 1..width) {
        when (direction) {
            Direction.LEFT -> result.add(this.getRow(i, jRange))
            Direction.RIGHT -> result.add(this.getRow(i, jRangeAsReversed))
        }
    }
    return result
}