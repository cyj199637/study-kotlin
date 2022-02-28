package assignment.week4

data class GameBoardImpl<Any>(override val width: Int): GameBoard<Any> {
    val board = mutableMapOf<Cell, Any?>()

    init {
        for (i in 1..width) {
            for (j in 1..width) {
                board.put(Cell(i, j), null)
            }
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return board.keys.find { cell -> cell.i == i && cell.j == j }
    }

    override fun getCell(i: Int, j: Int): Cell {
        if (i == 0 || j == 0) {
            throw IllegalArgumentException("i or j cannot be zero.")
        }

        if (i > width || j > width) {
            throw IllegalArgumentException("i or j cannot be bigger than width")
        }

        return board.keys.find { cell -> cell.i == i && cell.j == j }!!
    }

    override fun getAllCells(): Collection<Cell> {
        return board.keys
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val result =  board.keys.filter { cell -> cell.i == i && cell.j in jRange }
        return if (jRange.first <= jRange.last) result else result.asReversed()
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val result =  board.keys.filter { cell -> cell.i in iRange && cell.j == j }
        return if (iRange.first <= iRange.last) result else result.asReversed()
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        val (i, j) = when(direction) {
            Direction.UP -> i - 1 to j
            Direction.DOWN -> i + 1 to j
            Direction.LEFT -> i to j - 1
            Direction.RIGHT -> i to j + 1
        }
        return board.keys.find { cell -> cell.i == i && cell.j == j }
    }

    override fun get(cell: Cell): Any? {
        return board[cell]
    }

    override fun set(cell: Cell, value: Any?) {
        board.put(cell, value)
    }

    override fun filter(predicate: (Any?) -> Boolean): Collection<Cell> {
        return board.filter { (_, value) -> predicate(value) }.keys
    }

    override fun find(predicate: (Any?) -> Boolean): Cell? {
        return board.filter { (_, value) -> predicate(value) }.keys.firstOrNull()
    }

    override fun any(predicate: (Any?) -> Boolean): Boolean {
        return board.filter { (_, value) -> predicate(value) }.isNotEmpty()
    }

    override fun all(predicate: (Any?) -> Boolean): Boolean {
        if (null in board.values) {
            return false
        }

        return board.filter { (_, value) -> !predicate(value) }.isEmpty()
    }
}

fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width)