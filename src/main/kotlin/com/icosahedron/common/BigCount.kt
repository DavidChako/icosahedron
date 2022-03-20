package com.icosahedron.common

import java.math.BigInteger

data class BigCount(val value: BigInteger) {
    init { require(value >= BigInteger.ZERO) { "Value=$value is negative"} }

    constructor(value: Int): this(value.toBigInteger())

    override fun toString() = value.toString()
    operator fun plus(addend: BigCount) = BigCount(value + addend.value)

    fun plusOne() = BigCount(value + BigInteger.ONE)

    fun minusOne(): BigCount {
        if (value == BigInteger.ZERO) throw IllegalStateException("Unable to subtract from zero")
        return BigCount(value - BigInteger.ONE)
    }
}
