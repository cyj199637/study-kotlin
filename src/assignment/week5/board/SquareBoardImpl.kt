package board

open class SquareBoardImpl(override val width: Int): SquareBoard {
    override var cells: MutableList<Cell> = mutableListOf()

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
        return cells.find { cell -> cell.i == i && cell.j == j }
            ?: throw IllegalArgumentException()
    }

    override fun getAllCells(): Collection<Cell> {
        return cells
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        if (jRange.first > jRange.last) {
            return cells.filter { cell -> cell.i == i && cell.j in jRange }.asReversed()
        }
        return cells.filter { cell -> cell.i == i && cell.j in jRange }
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        if (iRange.first > iRange.last) {
            return cells.filter { cell -> cell.i in iRange && cell.j == j }.asReversed()
        }

        return cells.filter { cell -> cell.i in iRange && cell.j == j }
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        val (i, j) = when (direction) {
            Direction.UP -> i - 1 to j
            Direction.DOWN -> i + 1 to j
            Direction.LEFT -> i to j - 1
            Direction.RIGHT -> i to j + 1
        }
        return getCellOrNull(i, j)
    }
}