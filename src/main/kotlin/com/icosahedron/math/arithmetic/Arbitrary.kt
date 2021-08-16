package com.icosahedron.math.arithmetic

import com.icosahedron.math.geometry.tetrahedral.TetrayVector
import kotlin.random.Random

object Arbitrary {
    fun count() = Count(whole())
    fun whole() = wholeInt().toBigInteger()
    fun negative() = Random.nextLong(Long.MIN_VALUE, 0).toBigInteger()
    fun wholeInt() = Random.nextInt(0, Int.MAX_VALUE)
    fun tetray() = TetrayVector(count(), count(), count(), count())
}