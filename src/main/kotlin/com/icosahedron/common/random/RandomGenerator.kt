package com.icosahedron.common.random

interface RandomGenerator {
    fun nextInt(): Int
    fun nextInt(minimum: Int, upperBound: Int): Int

    fun nextLong(): Long
    fun nextLong(upperBound: Long): Long
}