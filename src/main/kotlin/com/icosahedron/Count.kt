package com.icosahedron

import java.math.BigInteger

inline class Count(private val value: Long) {
    constructor(value: BigInteger) : this(value.toLong())
    constructor(value: Int) : this(value.toLong())
    operator fun plus(other: Count) = Count(value + other.value)
    override fun toString() = value.toString()
}

//import java.math.BigInteger
//
//inline class BigIntegerCount(private val value: BigInteger) {
//    constructor(value: Long) : this(value.toBigInteger())
//    constructor(value: Int) : this(value.toBigInteger())
//    operator fun plus(other: BigIntegerCount) = BigIntegerCount(value + other.value)
//    override fun toString() = value.toString()
//}

