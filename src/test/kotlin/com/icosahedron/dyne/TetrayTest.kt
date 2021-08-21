package com.icosahedron.dyne

import kotlin.test.Test
import kotlin.test.assertEquals

class TetrayTest {
//        private var shell = x0 + x1 + x2 + x3
//            get() = field
//
//        constructor(x0: Int, x1: Int, x2: Int, x3: Int): this(x0.toULong(), x1.toULong(), x2.toULong(), x3.toULong())
//
//        override fun toString() = "$x0:$x1:$x2:$x3"
//
//        operator fun get(i: Int) = coordinate(i).get()
//
//        fun increment(i: Int): ULong {
//            val coordinate = coordinate(i)
//            val result = coordinate.get() + 1UL
//            coordinate.set(result)
//            shell++
//            return result
//        }
//
//        fun decrement(i: Int): ULong {
//            val coordinate = coordinate(i)
//            val result = coordinate.get() - 1UL
//            coordinate.set(result)
//            shell--
//            return result
//        }
//
//        private fun coordinate(i: Int) = when (i) {
//            0 -> this::x0
//            1 -> this::x1
//            2 -> this::x2
//            3 -> this::x3
//            else -> throw ArrayIndexOutOfBoundsException(i)
//        }

    @Test fun `construct from ULongs`() {
        val x0 = Arbitrary.ulong()
        val x1 = Arbitrary.ulong()
        val x2 = Arbitrary.ulong()
        val x3 = Arbitrary.ulong()
        val tetray = Tetray(x0, x1, x2, x3)
        assertEquals(x0, tetray[0])
        assertEquals(x1, tetray[1])
        assertEquals(x2, tetray[2])
        assertEquals(x3, tetray[3])
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