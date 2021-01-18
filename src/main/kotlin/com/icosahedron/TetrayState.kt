package com.icosahedron

class TetrayState(val w: Long, val x: Long, val y: Long, val z: Long) {
    operator fun get(offset: Int) = when (offset) {
        0 -> w
        1 -> x
        2 -> print("x == 2")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }

    fun increment(n: Int): Boolean {
        if (array[n] == Long.MAX_VALUE) return false
        array[n] = array[n] + 1
        return true
    }

    fun decrement(n: Int): Boolean {
        if (array[n] == 0L) return false
        array[n] = array[n] - 1
        return true
    }

    fun shift(from: Int, to: Int): Boolean {
        if (!decrement(from)) return false
        if (increment(to)) return true
        increment(from)
        return false
    }

    override fun toString() = array.contentToString()
}