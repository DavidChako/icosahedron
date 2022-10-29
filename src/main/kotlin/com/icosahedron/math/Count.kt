package com.icosahedron.math

@JvmInline
value class Count(val value: ULong = 0UL) {
    constructor(value: Int): this(value.toULong())
    operator fun plus(rhs: Count) = Count(value + rhs.value)
}