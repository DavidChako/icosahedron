package com.icosahedron.math.errata

import com.icosahedron.format.Format

fun main() {
    println("Hello Errata!")
    printFibonnaciNumbers()
}

fun printFibonnaciNumbers() {
    val title = "Fibonacci numbers"
    println(Format.blockBegin(title))
    (0 until 10).forEach { println("fibonacci($it) = ${Fibonacci.fibonacci(it)}") }
    println("...")
    println("fibonacci(10K) = ${Fibonacci.fibonacci(10_000)}")
    println(Format.blockEnd(title))
}
