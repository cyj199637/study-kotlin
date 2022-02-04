package assignment

import kotlin.math.floor

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers1(): Set<Driver> =
    this.allDrivers
        .filter { driver -> this.trips.none { it.driver == driver } }
        .toSet()

fun TaxiPark.findFakeDrivers2(): Set<Driver> =
    this.allDrivers - this.trips.map { it.driver }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers1(minTrips: Int): Set<Passenger> =
    this.allPassengers
        .filter { passenger -> this.trips.count { passenger in it.passengers } >= minTrips }
        .toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers1(driver: Driver): Set<Passenger> =
    TODO()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers1(): Set<Passenger> =
    TODO()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod1(): IntRange? {
    TODO()
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple1(): Boolean {
    TODO()
}