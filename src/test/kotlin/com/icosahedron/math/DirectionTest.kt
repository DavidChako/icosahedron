package com.icosahedron.math

import com.icosahedron.test.Arbitrary
import kotlin.test.Test
import kotlin.test.assertEquals

class DirectionTest {
    @Test fun `available directions`() {
        assertEquals(listOf(Direction.W, Direction.X, Direction.Y, Direction.Z), Direction.values().toList())
    }

    @Test fun `project tetray`() {
        val tetray = Arbitrary.tetray()
        val expectedProjections = listOf(tetray.w, tetray.x, tetray.y, tetray.z)
        val actualProjections = Direction.values().map { it.project(tetray) }
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
        val actualLocations = Direction.values().map { it.move(tetray) }
        assertEquals(expectedLocations, actualLocations)
    }
}