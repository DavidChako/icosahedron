package com.icosahedron.math

data class Tetray(val frequency: ULong, val a: ULong, val b: ULong, val c: ULong, val d: ULong) {
    val sum get() = a + b + c + d
    val mass get() = frequency * sum

}