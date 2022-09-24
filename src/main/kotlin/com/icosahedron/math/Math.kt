package com.icosahedron.math

import com.icosahedron.format.Format

fun main() {
    val stringToString = String::class.toString()
    println(stringToString)

    println("Hello Math!")
    printFibonnaciNumbers()
    println("Goodbye Math!")
}

fun printFibonnaciNumbers() {
    val title = "Fibonacci numbers"
    println(Format.blockBegin(title))
    (0 until 10).forEach { println("fibonacci($it) = ${Sequence.fibonacci(it)}") }
    println("...")
    println("fibonacci(10K) = ${Sequence.fibonacci(10_000)}")
    println(Format.blockEnd(title))
}
