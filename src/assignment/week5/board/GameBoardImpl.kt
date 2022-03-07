package board

class GameBoardImpl<Any>(override val width: Int): SquareBoardImpl(width), GameBoard<Any> {
    override val map = mutableMapOf<Cell, Any?>()

    init {
        for (i in 1..width) {
            for (j in 1..width) {
                val cell = Cell(i, j)
                cells.add(cell)
                map[cell] = null
            }
        }
    }

    override fun get(cell: Cell): Any? {
        return map[cell]
    }

    override fun set(cell: Cell, value: Any?) {
        map[cell] = value
    }

    override fun filter(predicate: (Any?) -> Boolean): Collection<Cell> {
        return map.filter { (_, value) -> predicate(value) }.keys
    }

    override fun find(predicate: (Any?) -> Boolean): Cell? {
        return map.entries.find { it -> predicate(it.value) }?.key
    }

    override fun any(predicate: (Any?) -> Boolean): Boolean {
        return map.any { (_, value) -> predicate(value) }
    }

    override fun all(predicate: (Any?) -> Boolean): Boolean {
        return map.all { (_, value) -> predicate(value) }
    }
}