package com.icosahedron.test

import com.icosahedron.math.Count
import kotlin.random.Random

object GenerateRandom {
    fun count() = Count(whole())
    fun whole() = wholeLong().toBigInteger()
    fun negative() = Random.nextLong(Long.MIN_VALUE, 0).toBigInteger()
    fun wholeInt() = Random.nextInt(0, Int.MAX_VALUE)
    fun wholeLong() = Random.nextLong(0, Long.MAX_VALUE)
}