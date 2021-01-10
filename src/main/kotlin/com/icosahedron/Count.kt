package com.icosahedron

import java.math.BigInteger

object Count {
    @JvmStatic fun of(value: BigInteger) = value
    @JvmStatic fun of(value: Long) = value.toBigInteger()
    @JvmStatic fun of(value: Int) = value.toBigInteger()

//    // can try using Long for better performance, at risk of overflow
//    @JvmStatic fun of(value: BigInteger) = value
//    @JvmStatic fun of(value: Long) = value
//    @JvmStatic fun of(value: Int) = value.toLong()
}