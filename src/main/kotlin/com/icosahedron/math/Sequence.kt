package com.icosahedron.math

import java.math.BigInteger

class Sequence {
    companion object {
        fun fibonacci(x: Int): BigInteger {
            tailrec fun fibonacci(val1: BigInteger, val2: BigInteger, x: BigInteger): BigInteger = when {
                (x == BigInteger.ZERO) -> BigInteger.ONE
                (x == BigInteger.ONE) -> val1 + val2
                else -> fibonacci(val2, val1 + val2, x - BigInteger.ONE)
            }
            return fibonacci(BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf(x.toLong()))
        }
    }
}