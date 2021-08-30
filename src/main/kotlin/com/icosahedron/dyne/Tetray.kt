package com.icosahedron.dyne

import java.math.BigInteger

data class Tetray constructor(private val coordinates: ArrayList<BigInteger>) : Iterable<BigInteger> {
    constructor(x0: Int, x1: Int, x2: Int, x3: Int): this(arrayListOf(x0.toBigInteger(), x1.toBigInteger(), x2.toBigInteger(), x3.toBigInteger()))

    override fun toString() = coordinates.joinToString(":")

    override fun iterator()= coordinates.iterator()

    operator fun get(n: Int) = coordinates[n]

    fun sum() = coordinates.sumOf { it }

    fun increment(n: Int) { coordinates[n] += BigInteger.ONE }

    fun decrement(n: Int) { coordinates[n] -= BigInteger.ONE }

    fun canDecrement(n: Int) = coordinates[n] != BigInteger.ZERO
}
