package controlstructure

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}

fun isValidIdentifier(s: String): Boolean {
    if (s.isNullOrEmpty())
        return false;

    val lower = s.lowercase()
    if (lower[0] != '_' && lower[0] !in 'a'..'z')
        return false

    val extra = lower.substring(1)
    for (c in extra) {
        if (c != '_' && c !in '0'..'9' && c !in 'a'..'z')
            return false
    }

    return true
}