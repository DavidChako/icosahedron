package com.icosahedron.dyne

class Tetray private constructor(private val array: Array<ULong>) {
    var shell = array.sum()
        private set

    constructor(x0: ULong, x1: ULong, x2: ULong, x3: ULong): this(arrayOf(x0, x1, x2, x3))

    constructor(x0: Int, x1: Int, x2: Int, x3: Int): this(x0.toULong(), x1.toULong(), x2.toULong(), x3.toULong())

    operator fun get(i: Int) = array[i]

    fun increment(i: Int): Tetray {
        require(array[i] < ULong.MAX_VALUE)
        array[i] = array[i] + 1UL
        shell += 1UL
        return this
    }

    fun decrement(i: Int): Tetray {
        require(array[i] > ULong.MIN_VALUE)
        array[i] = array[i] - 1UL
        shell -= 1UL
        return this
    }

    override fun toString() = array.joinToString(":")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return array.contentEquals((other as Tetray).array)
    }

    override fun hashCode(): Int {
        return array.contentHashCode()
    }
}
