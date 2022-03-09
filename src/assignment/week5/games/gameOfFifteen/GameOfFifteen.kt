package assignment.week5.games.gameOfFifteen

import assignment.week5.board.Cell
import assignment.week5.board.Direction
import assignment.week5.board.createGameBoard
import assignment.week5.games.game.Game

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
    GameOfFifteen(initializer)

class GameOfFifteen(val initializer: GameOfFifteenInitializer): Game {
    private val board = createGameBoard<Int?>(4)
    private val answer = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, null)

    override fun initialize() {
        val cells = board.getAllCells().toList()
        val randomValues = initializer.initialPermutation
        for (i in 0..15) {
            if (i == 15) {
                board[cells[15]] = null
                break
            }
            board[cells[i]] = randomValues[i]
        }
    }

    override fun canMove(): Boolean = board.any { it == null }

    override fun hasWon(): Boolean {
        val values = board.getAllCells().map { board[it] }
        return answer == values
    }

    override fun processMove(direction: Direction) {
        val emptyCell = board.find { it == null }!!
        when (direction) {
            Direction.UP -> {
                val i = emptyCell.i + 1
                val moveCell = Cell(i, emptyCell.j)
                val moveValue = board[moveCell]
                board[emptyCell] = moveValue
                board[moveCell] = null
            }
            Direction.DOWN -> {
                val i = emptyCell.i - 1
                val moveCell = Cell(i, emptyCell.j)
                val moveValue = board[moveCell]
                board[emptyCell] = moveValue
                board[moveCell] = null
            }
            Direction.LEFT -> {
                val j = emptyCell.j + 1
                val moveCell = Cell(emptyCell.i, j)
                val moveValue = board[moveCell]
                board[emptyCell] = moveValue
                board[moveCell] = null
            }
            Direction.RIGHT -> {
                val j = emptyCell.j - 1
                val moveCell = Cell(emptyCell.i, j)
                val moveValue = board[moveCell]
                board[emptyCell] = moveValue
                board[moveCell] = null
            }
        }
    }

    override fun get(i: Int, j: Int): Int? = board.run { get(getCell(i, j)) }
}