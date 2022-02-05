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
    this.trips
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        // filterValues(): 조건에 맞는 value를 가진 Entry로 이루어진 Map 반환
        .filterValues { group -> group.size >= minTrips }
        .keys

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers1(driver: Driver): Set<Passenger> =
    this.trips
        .filter { trip -> trip.driver == driver }
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size >= 2 }
        .keys

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers1(): Set<Passenger> =
    this.allPassengers
        // associateWith(): associate() 와 같은 기능이지만, associate() 는 key, value 모두 지정해야하는 반면
        // associateWith() 는 주어진 컬렉션의 element 를 그대로 key 로 사용한다.
        .associateWith { passenger -> this.trips.filter { passenger in it.passengers } }
        .filterValues { group ->
            val (normal, discount) = group.partition { it.discount == null }
            normal.size < discount.size }
        .keys

fun TaxiPark.findSmartPassengers2(): Set<Passenger> =
    this.allPassengers
        .filter { passenger ->
            val normal = this.trips.filter { passenger in it.passengers && it.discount == null }
            val discount = this.trips.filter { passenger in it.passengers && it.discount != null }
            normal.size < normal.size }
        .toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod1(): IntRange? {
    if (this.trips.isEmpty())
        return null

    return this.trips
        .groupBy { trip ->
            val start = (trip.duration / 10) * 10
            val end = start + 9
            start..end }
        .maxByOrNull { it.value.size }
        ?.key
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple1(): Boolean {
    if (this.trips.isEmpty())
        return false

    val countForTop20Pct = (this.allDrivers.size * 0.2).toInt()
    // Driver 가 누군지 상관없이 상위 20%의 총 수입만 알면 되기 때문에
    // 바로 Driver 별 수입 합계로 transforming 한다.
    val top20PctDriversTotalIncome = this.trips
        .groupBy(Trip::driver)
        .map { (_, tripsByDriver) -> tripsByDriver.sumOf(Trip::cost) }
        .sortedDescending()
        // take(): 컬렉션의 앞에서 부터 지정한 수 만큼의 element 를 반환
        .take(countForTop20Pct)
        .sum()

    val based = this.trips.sumOf(Trip::cost) * 0.8

    return top20PctDriversTotalIncome >= based
}