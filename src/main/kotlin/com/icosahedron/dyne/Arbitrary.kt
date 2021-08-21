package com.icosahedron.dyne

import kotlin.random.Random
import kotlin.random.nextULong

object Arbitrary {
    fun ulong() = Random.nextULong()
    fun tetray() = Tetray(ulong(), ulong(), ulong(), ulong())
}