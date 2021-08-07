package com.icosahedron.math

import com.icosahedron.test.RandomGen
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertNotSame
import kotlin.test.assertTrue

class TetrayTest {
    @Test fun `fail init if coordinate count is not 4`() {
        arrayOf(0, 1, 2, 3, 5, 6, 7, 8).forEach { coordinateCount ->
            val coordinates = RandomGen.uLongArray(coordinateCount)
            assertFailsWith(IllegalArgumentException::class, "For coordinate count $coordinateCount") { Tetray(coordinates) }
        }
    }

    @Test fun `construct from Ints`() {
        val coordinates = RandomGen.intArray(4)
        val actualTetray = Tetray(coordinates[0], coordinates[1], coordinates[2], coordinates[3])
        val expectedTetray = Tetray(coordinates.map { it.toULong() }.toTypedArray())
        assertEquals(expectedTetray, actualTetray)
    }

    @Test fun `shell property get`() {
        val coordinates = RandomGen.uLongArray(4)
        assertEquals(coordinates.sum(), Tetray(coordinates).shell)
    }

    @Test fun `to string`() {
        val coordinates = RandomGen.uLongArray(4)
        assertEquals(coordinates.joinToString(":"), Tetray(coordinates).toString())
    }

    @Test fun `equals and not equals`() {
        val coordinates = RandomGen.uLongArray(4)
        val tetray = Tetray(coordinates)
        assertEquals(tetray.copy(), tetray)

        val sameCoordinates = coordinates.map { it }.toTypedArray()
        assertTrue(sameCoordinates.contentEquals(coordinates))

        val equalTetray = Tetray(sameCoordinates)
        assertEquals(tetray, equalTetray)
        assertEquals(equalTetray, tetray)

        val differentCoordinates = coordinates.map { it + 1UL }.toTypedArray()
        assertFalse(coordinates.contentEquals(differentCoordinates))

        val differentTetray = Tetray(differentCoordinates)
        assertNotEquals(tetray, differentTetray)
        assertNotEquals(differentTetray, tetray)
    }

    @Test fun `equals is reflexive`() {
        val tetray = Tetray(RandomGen.uLongArray(4))
        assertEquals(tetray, tetray)
    }

    @Test fun `equals is symmetric`() {
        val coordinates = RandomGen.uLongArray(4)
        val tetray = Tetray(coordinates)
        val tetrayCopy = tetray.copy()
        assertNotSame(tetray, tetrayCopy)
        assertEquals(tetray, tetrayCopy)
        assertEquals(tetrayCopy, tetray)
    }

    @Test fun `equals is transitive`() {
        val coordinates = RandomGen.uLongArray(4)
        val tetray = Tetray(coordinates)
        val tetrayCopy = tetray.copy()
        val tetrayCopyCopy = tetrayCopy.copy()
        assertNotSame(tetray, tetrayCopy)
        assertNotSame(tetrayCopy, tetrayCopyCopy)
        assertEquals(tetray, tetrayCopy)
        assertEquals(tetrayCopy, tetrayCopyCopy)
        assertEquals(tetray, tetrayCopyCopy)
    }

    @Test fun `hash code`() {
        val coordinates = RandomGen.uLongArray(4)
        assertEquals(coordinates.contentHashCode(), Tetray(coordinates).hashCode())
    }

    @Test fun `coordinate for ordinal`() {
        val coordinates = RandomGen.uLongArray(4)
        val tetray = Tetray(coordinates)

        coordinates.forEachIndexed { ordinate, coordinate->
            assertEquals(coordinate, tetray.coordinate(ordinate))
        }
    }

    @Test fun `increment coordinate`() {
        val coordinates = RandomGen.uLongArray(4)
        val tetray = Tetray(coordinates)

        coordinates.forEachIndexed { ordinate, coordinate->
            tetray.incrementCoordinate(ordinate)
            assertEquals(coordinate + 1UL, tetray.coordinate(ordinate))
        }
    }
}