package com.icosahedron.math.geometry.tetrahedral

import com.icosahedron.math.arithmetic.Arbitrary
import kotlin.test.Test
import kotlin.test.assertEquals

class TetrayDirectionTest {
    @Test fun `available directions`() {
        assertEquals(listOf(TetrayDirection.W, TetrayDirection.X, TetrayDirection.Y, TetrayDirection.Z), TetrayDirection.values().toList())
    }

    @Test fun `project tetray`() {
        val tetray = Arbitrary.tetray()
        val expectedProjections = listOf(tetray.w, tetray.x, tetray.y, tetray.z)
        val actualProjections = TetrayDirection.values().map { it.project(tetray) }
        assertEquals(expectedProjections, actualProjections)
    }

    @Test fun `move tetray`() {
        val tetray = Arbitrary.tetray()
        val expectedLocations = listOf(
            Tetray(tetray.w.plusOne(), tetray.x, tetray.y, tetray.z),
            Tetray(tetray.w, tetray.x.plusOne(), tetray.y, tetray.z),
            Tetray(tetray.w, tetray.x, tetray.y.plusOne(), tetray.z),
            Tetray(tetray.w, tetray.x, tetray.y, tetray.z.plusOne()),
        )
        val actualLocations = TetrayDirection.values().map { it.move(tetray) }
        assertEquals(expectedLocations, actualLocations)
    }
}