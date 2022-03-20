package com.icosahedron.common

data class Tetray constructor(private val array: LongArray) : Iterable<Long> {
    init { require(array.size == 4) { "array size must be 4"} }

    constructor(x0: Long, x1: Long, x2: Long, x3: Long): this(longArrayOf(x0, x1, x2, x3))
    constructor(x0: Int, x1: Int, x2: Int, x3: Int): this(x0.toLong(), x1.toLong(), x2.toLong(), x3.toLong())

    fun sum() = array.sumOf { it }
    fun increment(n: Int) { array[n] = array[n] + 1 }
    fun decrement(n: Int) { array[n] = array[n] - 1 }

    override fun toString() = array.toString()
    override fun iterator()= array.iterator()
    operator fun get(n: Int) = array[n]
    override fun equals(other: Any?) = if (this === other) true else array.contentEquals((other as Tetray).array)
    override fun hashCode() = array.hashCode()
}
