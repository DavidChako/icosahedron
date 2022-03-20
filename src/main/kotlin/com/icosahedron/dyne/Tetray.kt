package com.icosahedron.dyne

class Tetray constructor(private val coordinates: LongArray) : Iterable<Long> {
    constructor(tetray: Tetray): this(tetray.coordinates.copyOf())
    constructor(x0: Int, x1: Int, x2: Int, x3: Int): this(longArrayOf(x0.toLong(), x1.toLong(), x2.toLong(), x3.toLong()))

    override fun toString() = coordinates.joinToString(":")

    override fun iterator()= coordinates.iterator()

    operator fun get(n: Int) = coordinates[n]

    fun sum() = coordinates.sumOf { it }

    fun increment(n: Int) { coordinates[n] = coordinates[n] + 1 }

    fun decrement(n: Int) { coordinates[n] = coordinates[n] - 1 }

    fun canDecrement(n: Int) = coordinates[n] > 0
}
