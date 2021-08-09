package com.icosahedron.math

import com.icosahedron.math.tetray.Tetray
import com.icosahedron.test.GenerateRandom
import kotlin.test.Test
import kotlin.test.assertEquals

class TetrayTest {
    private val w = GenerateRandom.count()
    private val x = GenerateRandom.count()
    private val y = GenerateRandom.count()
    private val z = GenerateRandom.count()

    @Test fun `construct from Ints`() {
        val wi = GenerateRandom.wholeInt()
        val xi = GenerateRandom.wholeInt()
        val yi = GenerateRandom.wholeInt()
        val zi = GenerateRandom.wholeInt()
        assertEquals(Tetray(Count(wi), Count(xi), Count(yi), Count(zi)), Tetray(wi, xi, yi, zi))
    }

    @Test fun `to string`() {
        assertEquals("$w:$x:$y:$z", Tetray(w, x, y, z).toString())
    }

    @Test fun `get shell`() {
        assertEquals(w + x + y + z, Tetray(w, x, y, z).shell)
    }


//    @Test fun `coordinate for ordinal`() {
//        val coordinates = RandomGen.uLongArray(4)
//        val tetray = TetrayOld(coordinates)
//
//        coordinates.forEachIndexed { ordinate, coordinate->
//            assertEquals(coordinate, tetray.coordinate(ordinate))
//        }
//    }
//
//    @Test fun `increment coordinate`() {
//        val coordinates = RandomGen.uLongArray(4)
//        val tetray = TetrayOld(coordinates)
//
//        coordinates.forEachIndexed { ordinate, coordinate->
//            tetray.incrementCoordinate(ordinate)
//            assertEquals(coordinate + 1UL, tetray.coordinate(ordinate))
//        }
//    }
}