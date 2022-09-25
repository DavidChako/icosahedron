package com.icosahedron.math

fun main() {
    (0 until 10).forEach { println("Fibonacci[$it] = ${FibonacciSequence.term(it) }") }
    println("...")
    println("fibonacci[10K] = ${FibonacciSequence.term(10_000)}")
}
