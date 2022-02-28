package assignment.week4

data class SquareBoardImpl(override val width: Int): SquareBoard {
    val cells = mutableListOf<Cell>()

    init {
        for (i in 1..width) {
            for (j in 1..width) {
                cells.add(Cell(i, j))
            }
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return cells.find { cell -> cell.i == i && cell.j == j }
    }

    override fun getCell(i: Int, j: Int): Cell {
        return cells.find { cell -> cell.i == i && cell.j == j } ?:
        throw IllegalArgumentException("i or j is incorrect values.")
    }

    override fun getAllCells(): Collection<Cell> {
        return cells
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val result = cells.filter { cell -> cell.i == i && cell.j in jRange }
        return if (jRange.first <= jRange.last) result else result.asReversed()
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val result = cells.filter { cell -> cell.i in iRange && cell.j == j }
        return if (iRange.first <= iRange.last) result else result.asReversed()
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        val (i, j) = when(direction) {
            Direction.UP -> i-1 to j
            Direction.DOWN -> i+1 to j
            Direction.LEFT -> i to j-1
            Direction.RIGHT -> i to j+1
        }

        return cells.find { cell -> cell.i == i && cell.j == j }
    }
}

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)