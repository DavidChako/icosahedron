package com.icosahedron.math.geometry.tetrahedral

import com.icosahedron.math.arithmetic.Count
import com.icosahedron.math.arithmetic.Arbitrary
import kotlin.test.Test
import kotlin.test.assertEquals

class TetrayVectorTest {
    @Test fun `construct from Ints`() {
        val h = Arbitrary.wholeInt()
        val i = Arbitrary.wholeInt()
        val j = Arbitrary.wholeInt()
        val k = Arbitrary.wholeInt()
        val expected = TetrayVector(Count(h), Count(i), Count(j), Count(k))
        assertEquals(expected, TetrayVector(h, i, j, k))
    }

    @Test fun `to string`() {
        val tetray = Arbitrary.tetray()
        val expected = "${tetray.w}:${tetray.x}:${tetray.y}:${tetray.z}"
        assertEquals(expected, tetray.toString())
    }

    @Test fun `get shell`() {
        val tetray = Arbitrary.tetray()
        val expected = tetray.w + tetray.x + tetray.y + tetray.z
        assertEquals(expected, tetray.shell)
    }

    @Test fun `coordinate in direction`() {
        val tetray = Arbitrary.tetray()
        TetrayDirection.values().forEach { direction ->
            assertEquals(direction.project(tetray), tetray.coordinate(direction))
        }
    }

    @Test fun `next in direction`() {
        val tetray = Arbitrary.tetray()
        TetrayDirection.values().forEach { direction ->
            assertEquals(direction.move(tetray), tetray.next(direction))
        }
    }
}