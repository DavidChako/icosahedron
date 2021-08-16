package com.icosahedron.math.geometry.tetrahedral

import com.icosahedron.math.arithmetic.Arbitrary
import kotlin.test.Test
import kotlin.test.assertEquals

class TetrayDirectionTest {
    @Test fun `available directions`() {
        val expected = listOf(TetrayDirection.W, TetrayDirection.X, TetrayDirection.Y, TetrayDirection.Z)
        assertEquals(expected, TetrayDirection.values().toList())
    }

    @Test fun `project tetray`() {
        val tetray = Arbitrary.tetray()
        val expected = listOf(tetray.w, tetray.x, tetray.y, tetray.z)
        assertEquals(expected, TetrayDirection.values().map { it.project(tetray) })
    }

    @Test fun `move tetray`() {
        val tetray = Arbitrary.tetray()
        val expected = listOf(
            TetrayVector(tetray.w.plusOne(), tetray.x, tetray.y, tetray.z),
            TetrayVector(tetray.w, tetray.x.plusOne(), tetray.y, tetray.z),
            TetrayVector(tetray.w, tetray.x, tetray.y.plusOne(), tetray.z),
            TetrayVector(tetray.w, tetray.x, tetray.y, tetray.z.plusOne()),
        )
        assertEquals(expected, TetrayDirection.values().map { it.move(tetray) })
    }
}