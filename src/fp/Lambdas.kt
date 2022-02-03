package fp

fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")

    // full syntax
    list.filter({i: Int -> i < 4})
    // when lambda is the last argument, it can be moved out of parentheses
    list.filter(){i: Int -> i < 4}
    // empty parentheses can be omitted
    list.filter{i: Int -> i < 4}
    // type can be omitted if it's clear from the context
    list.filter{i -> i < 4}
    // it denotes the argument if it's only one
    list.filter{it < 4}

    // full syntax
    map.mapValues { entry -> "${entry.key} -> ${entry.value}!"}
    // destructing syntax: 인자를 Pair 형태로 명시하여 바로 value 접근 가능
    map.mapValues {(key, value) -> "$key -> $value!"}
    // omit the parameter name if it's unused
    map.mapValues {(_, value) -> "$value!"}
}