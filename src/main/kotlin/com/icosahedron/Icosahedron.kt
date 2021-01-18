package com.icosahedron

fun main() {
    println("Hello")
    println(Tetray(31))
    println(Tetray(1,3,6,10))

    val tetray = Tetray(31)
    println(tetray)

    tetray.increment(0)
    println(tetray)

    tetray.decrement(1)
    println(tetray)

    tetray.increment(2)
    println(tetray)

    tetray.decrement(3)
    println(tetray)

    tetray.shift(0, 1)
    println(tetray)

    tetray.shift(2, 3)
    println(tetray)
}
