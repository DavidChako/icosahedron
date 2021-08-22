package com.icosahedron.dyne

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertNotSame

class TetrayTest {
    private val x0 = Random.nextInt(1, Int.MAX_VALUE).toULong()
    private val x1 = Random.nextInt(1, Int.MAX_VALUE).toULong()
    private val x2 = Random.nextInt(1, Int.MAX_VALUE).toULong()
    private val x3 = Random.nextInt(1, Int.MAX_VALUE).toULong()

    @Test fun `shell property get`() {
        val tetray = Tetray(x0, x1, x2, x3)
        assertEquals(x0 + x1 + x2 + x3, tetray.shell)
    }

    @Test fun `construct from ULongs and get at index`() {
        val tetray = Tetray(x0, x1, x2, x3)
        assertEquals(tetray[0], x0)
        assertEquals(tetray[1], x1)
        assertEquals(tetray[2], x2)
        assertEquals(tetray[3], x3)
    }

    @Test fun `construct from Ints`() {
        val tetray = Tetray(x0.toInt(), x1.toInt(), x2.toInt(), x3.toInt())
        assertEquals(Tetray(x0, x1, x2, x3), tetray)
    }

    @Test fun `increment at index`() {
        assertEquals(Tetray(x0 + 1UL, x1, x2, x3), Tetray(x0, x1, x2, x3).increment(0))
        assertEquals(Tetray(x0, x1 + 1UL, x2, x3), Tetray(x0, x1, x2, x3).increment(1))
        assertEquals(Tetray(x0, x1, x2 + 1UL, x3), Tetray(x0, x1, x2, x3).increment(2))
        assertEquals(Tetray(x0, x1, x2, x3 + 1UL), Tetray(x0, x1, x2, x3).increment(3))
    }

    @Test fun `decrement at index`() {
        assertEquals(Tetray(x0 - 1UL, x1, x2, x3), Tetray(x0, x1, x2, x3).decrement(0))
        assertEquals(Tetray(x0, x1 - 1UL, x2, x3), Tetray(x0, x1, x2, x3).decrement(1))
        assertEquals(Tetray(x0, x1, x2 - 1UL, x3), Tetray(x0, x1, x2, x3).decrement(2))
        assertEquals(Tetray(x0, x1, x2, x3 - 1UL), Tetray(x0, x1, x2, x3).decrement(3))
    }

    @Test fun `to string`() {
        val tetray = Tetray(x0, x1, x2, x3)
        assertEquals("$x0:$x1:$x2:$x3", tetray.toString())
    }

    @Test fun `equals is reflexive`() {
        val tetray = Tetray(x0, x1, x2, x3)
        assertEquals(tetray, tetray)
    }

    @Test fun `equals is symmetric`() {
        val tetrayA = Tetray(x0, x1, x2, x3)
        val tetrayB = Tetray(x0, x1, x2, x3)
        assertNotSame(tetrayA, tetrayB)
        assertEquals(tetrayA, tetrayB)
        assertEquals(tetrayB, tetrayA)
    }

    @Test fun `equals is transitive`() {
        val tetrayA = Tetray(x0, x1, x2, x3)
        val tetrayB = Tetray(x0, x1, x2, x3)
        val tetrayC = Tetray(x0, x1, x2, x3)
        assertNotSame(tetrayA, tetrayB)
        assertNotSame(tetrayB, tetrayC)
        assertEquals(tetrayA, tetrayB)
        assertEquals(tetrayB, tetrayC)
        assertEquals(tetrayA, tetrayC)
    }

    @Test fun `not equals`() {
        val tetray = Tetray(x0, x1, x2, x3)
        assertFalse(tetray.equals("foobar"))
        assertNotEquals(Tetray(x0 + 1UL, x1, x2, x3), tetray)
        assertNotEquals(Tetray(x0, x1 + 1UL, x2, x3), tetray)
        assertNotEquals(Tetray(x0, x1, x2 + 1UL, x3), tetray)
        assertNotEquals(Tetray(x0, x1, x2, x3 + 1UL), tetray)
    }

    @Test fun `hash code`() {
        val tetray = Tetray(x0, x1, x2, x3)
        assertEquals(arrayOf(x0, x1, x2, x3).contentHashCode(), tetray.hashCode())
    }
}