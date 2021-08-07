package com.icosahedron.test

import kotlin.random.Random
import kotlin.random.nextULong

@Suppress("MemberVisibilityCanBePrivate")
object RandomGen {
    fun intCount() = intCount(Int.MAX_VALUE)
    fun intCount(upperBound: Int) = intCount(0, upperBound)
    fun intCount(lowerValue: Int, upperBound: Int) = Random.nextInt(lowerValue, upperBound)
    fun intArray(size: Int) = Array(size) { intCount() }

    fun uLongCount() = uLongCount(ULong.MAX_VALUE)
    fun uLongCount(upperBound: ULong) = uLongCount(0UL, upperBound)
    fun uLongCount(lowerValue: ULong, upperBound: ULong) = Random.nextULong(lowerValue, upperBound)
    fun uLongArray(size: Int) = Array(size) { uLongCount() }
}