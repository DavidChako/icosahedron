package com.icosahedron.math

import kotlin.test.Test

class SpanTest {
    @Test fun `to string`() {
        val a = Tetray(1, 2, 3, 4)
        val b = Tetray(4, 3, 2, 1)
        val span = Span(a, b)
        println(span)

        val resultSpan = span.move(Direction.W, Direction.X)
        println(resultSpan)
    }
}