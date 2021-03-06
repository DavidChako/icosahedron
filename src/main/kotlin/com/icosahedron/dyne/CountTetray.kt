package com.icosahedron.dyne

import com.icosahedron.common.BigCount

data class CountTetray constructor(val x0: BigCount, val x1: BigCount, val x2: BigCount, val x3: BigCount) {
    constructor(x0: Int, x1: Int, x2: Int, x3: Int): this(BigCount(x0), BigCount(x1), BigCount(x2), BigCount(x3))

    fun shell() = x0 + x1 + x2 + x3
    override fun toString() = "$x0:$x1:$x2:$x3"

    operator fun get(i: Int) = when (i) {
        0 -> x0
        1 -> x1
        2 -> x2
        3 -> x3
        else -> throw ArrayIndexOutOfBoundsException(i.toString())
    }

    fun increment(i: Int)  = when (i) {
        0 -> CountTetray(x0.plusOne(), x1, x2, x3)
        1 -> CountTetray(x0, x1.plusOne(), x2, x3)
        2 -> CountTetray(x0, x1, x2.plusOne(), x3)
        3 -> CountTetray(x0, x1, x2, x3.plusOne())
        else -> throw ArrayIndexOutOfBoundsException(i.toString())
    }

    fun decrement(i: Int)  = when (i) {
        0 -> CountTetray(x0.minusOne(), x1, x2, x3)
        1 -> CountTetray(x0, x1.minusOne(), x2, x3)
        2 -> CountTetray(x0, x1, x2.minusOne(), x3)
        3 -> CountTetray(x0, x1, x2, x3.minusOne())
        else -> throw ArrayIndexOutOfBoundsException(i.toString())
    }
}
