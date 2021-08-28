package com.icosahedron.dyne

data class Tetray constructor(private val coordinates: ArrayList<ULong>) {
    constructor(x0: ULong, x1: ULong, x2: ULong, x3: ULong): this(arrayListOf(x0, x1, x2, x3))
    constructor(x0: Int, x1: Int, x2: Int, x3: Int): this(x0.toULong(), x1.toULong(), x2.toULong(), x3.toULong())
    override fun toString() = coordinates.joinToString(":")
    operator fun get(n: Int) = coordinates[n]
    fun shell() = coordinates.sum()

    fun increment(n: Int) = if (coordinates[n] != ULong.MAX_VALUE) {
        coordinates[n] += 1UL
        true
    } else {
        false
    }

    fun decrement(n: Int) = if (coordinates[n] != ULong.MIN_VALUE) {
        coordinates[n] -= 1UL
        true
    } else {
        false
    }
}
