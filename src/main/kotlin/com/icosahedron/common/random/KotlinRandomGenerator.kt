package com.icosahedron.common.random

import kotlin.random.Random

class KotlinRandomGenerator : RandomGenerator {
    override fun nextInt() = Random.nextInt()
    override fun nextInt(minimum: Int, upperBound: Int) = Random.nextInt(minimum, upperBound)
    override fun nextLong() = Random.nextLong()
    override fun nextLong(upperBound: Long) = Random.nextLong(upperBound)
}