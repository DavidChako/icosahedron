package com.icosahedron.math

data class Span(val a: Tetray, val b: Tetray) {
    val length = computeLength(this)
    fun move(aDirection: Direction, bDirection: Direction) = Span(aDirection.increment(a), bDirection.increment(b))
    fun factor(aDirection: Direction, bDirection: Direction): Double = TODO()

    companion object {
        fun computeLength(span: Span) {
            TODO()
        }
    }
}
