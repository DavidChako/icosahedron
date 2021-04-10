package com.icosahedron.math

import com.icosahedron.format.Format

fun main() {
    println("Hello Math!")
    printFibonnaciNumbers()
}

fun printFibonnaciNumbers() {
    val title = "Fibonacci numbers"
    println(Format.blockBegin(title))
    (0 until 10).forEach { println("fibonacci($it) = ${Sequence.fibonacci(it)}") }
    println("...")
    println("fibonacci(10K) = ${Sequence.fibonacci(10_000)}")
    println(Format.blockEnd(title))
}
