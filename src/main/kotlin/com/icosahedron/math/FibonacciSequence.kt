package com.icosahedron.math

import java.math.BigInteger

object FibonacciSequence {
    fun term(x: Int): BigInteger {
        tailrec fun term(val1: BigInteger, val2: BigInteger, x: BigInteger): BigInteger = when {
            (x == BigInteger.ZERO) -> BigInteger.ONE
            (x == BigInteger.ONE) -> val1 + val2
            else -> term(val2, val1 + val2, x - BigInteger.ONE)
        }

        return term(BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf(x.toLong()))
    }
}