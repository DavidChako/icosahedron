package com.icosahedron.test

import kotlin.random.Random

object RandomGen {
    fun intCount() = intCount(Int.MAX_VALUE)
    fun intCount(upperBound: Int) = intCount(0, upperBound)
    fun intCount(lowerValue: Int, upperBound: Int) = Random.nextInt(lowerValue, upperBound)

    fun longCount() = longCount(Long.MAX_VALUE)
    fun longCount(upperBound: Long) = longCount(0, upperBound)
    fun longCount(lowerValue: Long, upperBound: Long) = Random.nextLong(lowerValue, upperBound)
}