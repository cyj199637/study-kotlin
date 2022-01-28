class Weather {
    fun updateWeather(degrees: Int) {
        val (description, color) = when {
            degrees < 10 -> "cole" to Color.BLUE
            degrees < 25 -> "mild" to Color.ORANGE
            else -> "hot" to Color.RED
        }
    }
}