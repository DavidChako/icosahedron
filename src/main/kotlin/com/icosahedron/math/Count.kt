package com.icosahedron.math

import java.math.BigInteger

data class Count(private val value: BigInteger) {
    init {
        require(value.signum() != -1) {
            "Negative value: $value"
        }
    }

    constructor(value: Int): this(value.toBigInteger())
    constructor(value: Long): this(value.toBigInteger())
    override fun toString() = value.toString()
    operator fun plus(addend: Count) = Count(value + addend.value)
    fun plusOne() = Count(value + BigInteger.ONE)
}
