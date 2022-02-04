package fp

fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap l@ {
        if (it == 0) return@l listOf()
        listOf(it, it)
    }
}

fun duplicateNonZeroLocalFunction(list: List<Int>): List<Int> {
    fun duplicateNonZeroElement(e: Int): List<Int> {
        if (e == 0) return listOf()
        return listOf(e, e)
    }

    return list.flatMap(::duplicateNonZeroElement)
}

fun duplicateNonZeroAnonymousFunction(list: List<Int>): List<Int> {
    return list.flatMap(fun (e: Int): List<Int> {
        if (e == 0) return listOf()
        return listOf(e, e)
    })
}

fun duplicateNonZeroNoReturn(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0)
            listOf()
        else
            listOf(it, it)
    }
}

fun containsZeroForLoop(list: List<Int>): Boolean {
    for (i in list) {
        if (i == 0)
            return true
    }
    return false
}

fun main() {
    val list = listOf(3, 0, 5)
    println(duplicateNonZero(list))
    println(containsZeroForLoop(list))
}