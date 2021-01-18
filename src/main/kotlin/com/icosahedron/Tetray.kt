package com.icosahedron

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion
import java.lang.IllegalArgumentException

data class Tetray(val w: Long, val x: Long, val y: Long, val z: Long) {
    companion object Space {
        private val cache = HashSet<Tetray>()
        private fun lookup()
    }

    operator fun get(offset: Int) = when (offset) {
        0 -> w
        1 -> x
        2 -> y
        3 -> z
        else -> throw ArrayIndexOutOfBoundsException(offset)
    }

    fun canIncrement(offset: Int) = get(offset) != Long.MAX_VALUE
    fun increment(offset: Int) = move(offset, +1)

    fun canDecrement(offset: Int) = get(offset) != 0L
    fun decrement(offset: Int) = move(offset, -1)

    fun canShift(toOffset: Int, fromOffset: Int) = canIncrement(toOffset) && canDecrement(fromOffset)
    fun shift(from: Int, to: Int) = if canShift()
        if (cannotDec(from)) return false
        if (increment(to)) return true
        increment(from)
        return false
    }

    private fun move(offset: Int, delta: Long) = when (offset) {
        0 -> copy(w = w + delta)
        1 -> copy(x = x + delta)
        2 -> copy(y = y + delta)
        3 -> copy(z = z + delta)
        else -> null
    }
}