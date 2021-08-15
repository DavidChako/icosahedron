package com.icosahedron.math.geometry.tetrahedral

import com.icosahedron.math.arithmetic.Count
import com.icosahedron.math.arithmetic.Arbitrary
import kotlin.test.Test
import kotlin.test.assertEquals

class TetrayTest {
    private val w = Arbitrary.count()
    private val x = Arbitrary.count()
    private val y = Arbitrary.count()
    private val z = Arbitrary.count()

    @Test fun `construct from Ints`() {
        val wi = Arbitrary.wholeInt()
        val xi = Arbitrary.wholeInt()
        val yi = Arbitrary.wholeInt()
        val zi = Arbitrary.wholeInt()
        assertEquals(Tetray(Count(wi), Count(xi), Count(yi), Count(zi)), Tetray(wi, xi, yi, zi))
    }

    @Test fun `to string`() {
        assertEquals("$w:$x:$y:$z", Tetray(w, x, y, z).toString())
    }

    @Test fun `get shell`() {
        assertEquals(w + x + y + z, Tetray(w, x, y, z).shell)
    }

    @Test fun `coordinate in direction`() {
        val tetray = Arbitrary.tetray()
        Direction.values().forEach { direction ->
            assertEquals(direction.project(tetray), tetray.coordinate(direction))
        }
    }

    @Test fun `next in direction`() {
        val tetray = Arbitrary.tetray()
        Direction.values().forEach { direction ->
            assertEquals(direction.move(tetray), tetray.next(direction))
        }
    }
}