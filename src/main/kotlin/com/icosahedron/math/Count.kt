package com.icosahedron.math

@JvmInline
value class Count(val value: ULong = 0UL) {
    constructor(value: Int): this(value.toLong().toULong())
}