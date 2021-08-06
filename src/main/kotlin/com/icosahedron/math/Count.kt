package com.icosahedron.math

import java.math.BigInteger

data class Count(val count: BigInteger) {
    init {
        require(count.signum() != -1) {
            "Invalid count: $count"
        }
    }

    constructor(count: Int): this(count.toBigInteger())
    constructor(count: Long): this(count.toBigInteger())
    override fun toString() = count.toString()
}
