package com.icosahedron.common.random

import kotlin.random.Random

class KotlinRandomGenerator : RandomGenerator {
    override fun nextInt(minimum: Int, upperBound: Int) = Random.nextInt(minimum, upperBound)
}