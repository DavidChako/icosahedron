package com.icosahedron.dyne

data class Tetray(private var x0: ULong, private var x1: ULong, private var x2: ULong, private var x3: ULong) {
    var shell = x0 + x1 + x2 + x3
        private set
        get() = field

    constructor(x0: Int, x1: Int, x2: Int, x3: Int): this(x0.toULong(), x1.toULong(), x2.toULong(), x3.toULong())

    override fun toString() = "$x0:$x1:$x2:$x3"

    operator fun get(i: Int) = coordinate(i).get()

    fun increment(i: Int): Tetray {
        val coordinate = coordinate(i)
        val result = coordinate.get() + 1UL
        coordinate.set(result)
        shell++
        return this
    }

    fun decrement(i: Int): Tetray {
        val coordinate = coordinate(i)
        val result = coordinate.get() - 1UL
        coordinate.set(result)
        shell--
        return this
    }

    private fun coordinate(i: Int) = when (i) {
        0 -> this::x0
        1 -> this::x1
        2 -> this::x2
        3 -> this::x3
        else -> throw ArrayIndexOutOfBoundsException(i)
    }
}
