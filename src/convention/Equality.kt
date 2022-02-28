package convention

/**
 * Implement 'equals2' without using '==' so that it was equivalent to 'equals1'.
 * You can call 'equals()' directly and use the reference equality operator '==='.
 */

data class Value(val s: String)

fun equals1(v1: Value?, v2: Value?): Boolean {
    return v1 == v2
}

fun equals2(v1: Value?, v2: Value?): Boolean =
    v1?.equals(v2) ?: (v2 === null)

fun main(args: Array<String>) {
    equals1(Value("abc"), Value("abc")) == true
    equals1(Value("abc"), null) == false
    equals1(null, Value("abc")) == false
    equals1(null, null) == true

    equals2(Value("abc"), Value("abc")) == true
    equals2(Value("abc"), null) == false
    equals2(null, Value("abc")) == false
    equals2(null, null) == true
}