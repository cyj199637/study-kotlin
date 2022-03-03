package lambda

/**
 * Simplify the following code using more appropriate auxiliary functions (with, let, run, apply, also).
 */

interface X {
    var first: Int
    var second: Int
    var third: Int
}

interface Y {
    fun start()
    fun finish()
}

interface Z {
    fun init()
}

fun foo(x: X, y: Y?, z: Z) {
    /**
     * apply() 를 써도 동일한 결과가 나오지만, apply 는 receiver 를 반환하기 때문에
     * 이 경우에는 with() 를 쓰는 것이 좀 더 적절하다.
     */
    with(x) {
        first = 1
        second = 2
        third = 3
    }
    y?.run {
        start()
        finish()
    }
    val result = z.apply {
        init()
    }
}