package com.icosahedron

import java.math.BigInteger

inline class BigIntegerCount(private val value: BigInteger) {
    constructor(value: Long) : this(value.toBigInteger())
    constructor(value: Int) : this(value.toBigInteger())
    operator fun plus(other: BigIntegerCount) = BigIntegerCount(value + other.value)
    override fun toString() = value.toString()
}
