package com.icosahedron.dyne

import kotlin.random.Random
import kotlin.random.nextULong

object Arbitrary {
    fun integer() = Random.nextInt()
    fun unsignedLong() = Random.nextULong()
    fun tetray() = Tetray(unsignedLong(), unsignedLong(), unsignedLong(), unsignedLong())
}