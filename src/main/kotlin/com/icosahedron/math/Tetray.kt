package com.icosahedron.math

data class Tetray(private val coordinates: Array<ULong> = Array(4) { 0UL }) {
    init { require(coordinates.size == 4) }
    constructor(w: Int, x: Int, y: Int, z: Int): this(arrayOf(w.toULong(), x.toULong(), y.toULong(), z.toULong()))

    val shell: ULong get() = coordinates.sum()

    override fun toString() = coordinates.joinToString(":")

    override fun equals(other: Any?) = when {
        this === other -> true
        javaClass != other?.javaClass -> false
        else -> coordinates.contentEquals((other as Tetray).coordinates)
    }

    override fun hashCode() = coordinates.contentHashCode()

    fun coordinate(ordinate: Int) = coordinates[ordinate]

    fun incrementCoordinate(ordinate: Int) = run {
        coordinates[ordinate] = coordinate(ordinate) + 1UL
    }
}
