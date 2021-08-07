package com.icosahedron.test

import kotlin.random.Random
import kotlin.random.nextULong

@Suppress("MemberVisibilityCanBePrivate")
object RandomGen {
    fun intCount() = intCount(Int.MAX_VALUE)
    fun intCount(upperBound: Int) = intCount(0, upperBound)
    fun intCount(lowerValue: Int, upperBound: Int) = Random.nextInt(lowerValue, upperBound)
    fun intCountArray(size: Int) = Array(size) { intCount() }

    fun uLong() = uLong(ULong.MAX_VALUE)
    fun uLong(upperBound: ULong) = uLong(0UL, upperBound)
    fun uLong(lowerValue: ULong, upperBound: ULong) = Random.nextULong(lowerValue, upperBound)
    fun uLongArray(size: Int) = Array(size) { uLong() }
}