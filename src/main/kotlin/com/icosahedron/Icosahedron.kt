package com.icosahedron

//import com.icosahedron.BigIntegerCount as Count

fun main() {
    val foobar = Count(1)
    val barfoo = Count(10L)
    val barbar = Count(100L.toBigInteger())
    val sum = foobar + barfoo + barbar

    println("Hello")
    println(foobar)
    println(barfoo)
    println(barbar)
    println(sum)
}
