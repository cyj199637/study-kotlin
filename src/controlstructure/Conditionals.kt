package controlstructure

fun main() {
    when (val pet = getMyFavoritePet()) {
        is Cat -> pet.meow()
        is Dog -> pet.woof()
    }

    val degree = 21
    val (description, color) = when {
        degree < 10 -> "cold" to Color.BLUE
        degree < 25 -> "mild" to Color.ORANGE
        else -> "hot" to Color.RED
    }
}

fun getMyFavoritePet(): Pet = Cat()

fun getDescription(color: Color): String =
    when (color)  {
        Color.BLUE -> "blue"
        Color.ORANGE -> "orange"
        Color.RED -> "red"
        else -> "Unnecessary Color"
    }

fun getMixDescription(color1: Color, color2: Color): Color =
    when (setOf(color1, color2))  {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Will Be Dirty Color")
    }

fun respondToInput(input: String): String =
    when (input)  {
        "y", "yes" -> "I'm glad you agree"
        "n", "no" -> "Sorry to hear that"
        else -> "I don't understand you"
    }