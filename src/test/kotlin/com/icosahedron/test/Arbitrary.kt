package com.icosahedron.test

import com.icosahedron.math.Count
import com.icosahedron.math.Tetray
import kotlin.random.Random

object Arbitrary {
    fun count() = Count(whole())
    fun whole() = wholeInt().toBigInteger()
    fun negative() = Random.nextLong(Long.MIN_VALUE, 0).toBigInteger()
    fun wholeInt() = Random.nextInt(0, Int.MAX_VALUE)
    fun tetray() = Tetray(count(), count(), count(), count())
}