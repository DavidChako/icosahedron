package com.icosahedron

import java.math.BigInteger as Count

//import kotlin.Long as Count
//fun Count.Companion.valueOf(value: Count) = value
//fun Count.Companion.valueOf(value: Int) = value.toLong()

val foobar: Count = Count.valueOf(1)
val barfoo = Count.of(100L)
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
