package com.icosahedron.math

import com.icosahedron.test.RandomGen
import kotlin.test.Test
import kotlin.test.assertEquals

class TetrayTest {
    private val upperBound = 100
    private val w = RandomGen.intCount(upperBound)
    private val x = RandomGen.intCount(upperBound)
    private val y = RandomGen.intCount(upperBound)
    private val z = RandomGen.intCount(upperBound)

    @Test fun `construct from Ints`() {
        val actualTetray = Tetray(w, x, y, z)
        val expectedTetray = Tetray(Count(w),Count(x),Count(y),Count(z))
        assertEquals(expectedTetray, actualTetray)
    }

    @Test fun `to string`() {
        val tetray = Tetray(w, x, y, z)
        val actualString = tetray.toString()
        val expectedString = "$w:$x:$y:$z"
        assertEquals(expectedString, actualString)
    }
}