package assignment.week4

import java.math.BigInteger

data class Rational(var n: BigInteger, var d: BigInteger): Comparable<Rational> {
    init {
        if (d == BigInteger.ZERO) {
            throw IllegalArgumentException("The denominator cannot be zero.")
        }

        if (d < BigInteger.ZERO) {
            n = -n
            d = -d
        }
    }

    constructor(n: Int, d: Int): this(n.toBigInteger(), d.toBigInteger())
    constructor(n: Long, d: Long): this(n.toBigInteger(), d.toBigInteger())

    override fun toString(): String {
        val gcd = n.gcd(d)
        return when {
            d.div(gcd) == BigInteger.ONE -> (n.div(gcd)).toString()
            else -> (n.div(gcd)).toString() + "/" + d.div(gcd).toString()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            throw IllegalArgumentException("The other is null.")
        }

        if (other !is Rational) {
            throw IllegalArgumentException("The other is not instance of Rational class.")
        }

        val gcd = n.gcd(d)
        val otherGcd = other.n.gcd(other.d)
        return (n.div(gcd) == other.n.div(otherGcd)) && (d.div(gcd) == other.d.div(otherGcd))
    }

    override fun compareTo(other: Rational): Int {
        val result = ((n * other.d) - (other.n * d))
        return when {
            result > BigInteger.ZERO -> 1
            result < BigInteger.ZERO -> -1
            else -> 0
        }
    }
}

operator fun Rational.plus(other: Rational): Rational {
    val numerator = (n * other.d) + (other.n * d)
    val denominator = d * other.d
    val gcd = numerator.gcd(denominator)
    return Rational(numerator.div(gcd), denominator.div(gcd))
}

operator fun Rational.minus(other: Rational): Rational {
    val numerator = (n * other.d) - (other.n * d)
    val denominator = d * other.d
    val gcd = numerator.gcd(denominator)
    return Rational(numerator.div(gcd), denominator.div(gcd))
}

operator fun Rational.times(other: Rational): Rational {
    val numerator = n * other.n
    val denominator = d * other.d
    val gcd = numerator.gcd(denominator)
    return Rational(numerator.div(gcd), denominator.div(gcd))
}

operator fun Rational.div(other: Rational): Rational {
    val numerator = n * other.d
    val denominator = d * other.n
    val gcd = numerator.gcd(denominator)
    return Rational(numerator.div(gcd), denominator.div(gcd))
}

operator fun Rational.unaryMinus(): Rational {
    return Rational(-n, d)
}

fun String.toRational(): Rational {
    val result = this.split("/")
    val n = result[0]
    val d = if (result.size != 1) result[1] else "1"
    return Rational(n.toBigInteger(), d.toBigInteger())
}

infix fun Int.divBy(other: Int) = Rational(this, other)
infix fun Long.divBy(other: Long) = Rational(this, other)
infix fun BigInteger.divBy(other: BigInteger) = Rational(this, other)

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}