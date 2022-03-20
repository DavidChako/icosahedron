package com.icosahedron.common.random

interface RandomGenerator {
    fun nextInt(minimum: Int, upperBound: Int): Int
}