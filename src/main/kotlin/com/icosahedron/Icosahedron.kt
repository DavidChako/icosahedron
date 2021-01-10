package com.icosahedron

//import java.math.BigInteger
//typealias Count = BigInteger

typealias Count = Long
fun Long.Companion.valueOf(value: Long) = value
fun Long.Companion.valueOf(value: Int) = value.toLong()

val foobar = Count.valueOf(1)
val barfoo = Count.valueOf(100L)
val sum = foobar + barfoo

fun main() {
    println("Hello")
    println(foobar)
    println(barfoo)
    println(sum)
//    implementMe()
}

// Errata
fun implementMe(): Unit = TODO("Implement me!")
