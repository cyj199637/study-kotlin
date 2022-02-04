package assignment

import kotlin.math.floor

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    this.allDrivers
        .filter { driver -> driver !in this.trips.map { it.driver } }
        .toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    this.allPassengers
        .filter { passenger -> this.trips.count { passenger in it.passengers } >= minTrips }
        .toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    this.allPassengers
        .filter { passenger -> this.trips.count { passenger in it.passengers && driver == it.driver } >= 2 }
        .toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    this.allPassengers
        .filter { this.trips.isSmartPassenger(it) }
        .toSet()

fun List<Trip>.isSmartPassenger(passenger: Passenger): Boolean {
    val (normal, discount) = this
        .filter { passenger in it.passengers }
        .partition { it.discount == null }

    return normal.size < discount.size
}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    if (this.trips.isEmpty())
        return null

    return this.trips
        .groupBy { ((it.duration / 10) * 10)..(it.duration / 10) * 10 + 9 }
        .maxByOrNull { it.value.size }
        ?.key
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (this.trips.isEmpty())
        return false

    val countForTop20Pct = floor(this.allDrivers.size * 0.2).toInt()
    val top20PctDriversTotalIncome = this.trips
        .groupBy { it.driver }
        .mapValues { it.value.sumOf { trip -> trip.cost } }
        .toList()
        .sortedByDescending { it.second }
        .subList(0, countForTop20Pct)
        .sumOf { it.second }

    val based = this.trips.sumOf { it.cost } * 0.8

    return top20PctDriversTotalIncome >= based
}