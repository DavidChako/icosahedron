package com.icosahedron

//import java.math.BigInteger
//typealias Count = BigInteger

typealias Count = Long

// align with BigInteger construction pattern
fun Long.Companion.valueOf(value: Long) = value
fun Long.Companion.valueOf(value: Int) = value.toLong()


