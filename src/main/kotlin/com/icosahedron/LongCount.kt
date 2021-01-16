package com.icosahedron

import java.math.BigInteger

inline class LongCount(private val value: Long) {
    constructor(value: BigInteger) : this(value.toLong())
    constructor(value: Int) : this(value.toLong())
    operator fun plus(other: LongCount) = LongCount(value + other.value)
    override fun toString() = value.toString()
}
