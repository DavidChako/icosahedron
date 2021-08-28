package com.icosahedron.dyne

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

class CountTetrayTest {
    private val n0 = Random.nextInt(0, Int.MAX_VALUE)
    private val n1 = Random.nextInt(0, Int.MAX_VALUE)
    private val n2 = Random.nextInt(0, Int.MAX_VALUE)
    private val n3 = Random.nextInt(0, Int.MAX_VALUE)

    private val x0 = Count(n0)
    private val x1 = Count(n1)
    private val x2 = Count(n2)
    private val x3 = Count(n3)

    @Test fun `tetray equals`() {
        assertEquals(Tetray(n0, n1, n2, n3), Tetray(n0, n1, n2, n3))
        assertNotEquals(Tetray(n0+1, n1, n2, n3), Tetray(n0, n1, n2, n3))
    }

    @Test fun `construct from Ints`() {
        val tetray = CountTetray(n0, n1, n2, n3)
        assertEquals(CountTetray(x0, x1, x2, x3), tetray)
    }

    @Test fun `shell is sum of components`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals(x0 + x1 + x2 + x3, tetray.shell())
    }

    @Test fun `to string`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals("$x0:$x1:$x2:$x3", tetray.toString())
    }

    @Test fun `get at index`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals(tetray[0], x0)
        assertEquals(tetray[1], x1)
        assertEquals(tetray[2], x2)
        assertEquals(tetray[3], x3)

        val invalidIndex = 4
        val expectedException = assertFailsWith(ArrayIndexOutOfBoundsException::class) {
            tetray[invalidIndex]
        }

        assertEquals(invalidIndex.toString(), expectedException.message)
    }

    @Test fun `increment at index`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals(CountTetray(x0.plusOne(), x1, x2, x3), tetray.increment(0))
        assertEquals(CountTetray(x0, x1.plusOne(), x2, x3), tetray.increment(1))
        assertEquals(CountTetray(x0, x1, x2.plusOne(), x3), tetray.increment(2))
        assertEquals(CountTetray(x0, x1, x2, x3.plusOne()), tetray.increment(3))

        val invalidIndex = 4
        val expectedException = assertFailsWith(ArrayIndexOutOfBoundsException::class) {
            tetray[invalidIndex]
        }

        assertEquals(invalidIndex.toString(), expectedException.message)
    }

    @Test fun `decrement at index`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals(CountTetray(x0.minusOne(), x1, x2, x3), tetray.decrement(0))
        assertEquals(CountTetray(x0, x1.minusOne(), x2, x3), tetray.decrement(1))
        assertEquals(CountTetray(x0, x1, x2.minusOne(), x3), tetray.decrement(2))
        assertEquals(CountTetray(x0, x1, x2, x3.minusOne()), tetray.decrement(3))

        val invalidIndex = 4
        val expectedException = assertFailsWith(ArrayIndexOutOfBoundsException::class) {
            tetray[invalidIndex]
        }

        assertEquals(invalidIndex.toString(), expectedException.message)
    }
}