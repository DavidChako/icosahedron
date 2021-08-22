package com.icosahedron.dyne

import kotlin.test.Test
import kotlin.test.assertEquals

class TetrayTest {
    @Test fun `construct from ULongs`() {
        // given
        val x0 = Arbitrary.unsignedLong()
        val x1 = Arbitrary.unsignedLong()
        val x2 = Arbitrary.unsignedLong()
        val x3 = Arbitrary.unsignedLong()
        val tetray = Tetray(x0, x1, x2, x3)

        // when
        val actual = listOf(tetray[0], tetray[1], tetray[2], tetray[3])

        // then
        val expected = listOf(x0, x1, x2, x3)
        assertEquals(expected, actual)
    }

    @Test fun `construct from Ints`() {
        // given
        val x0 = Arbitrary.integer()
        val x1 = Arbitrary.integer()
        val x2 = Arbitrary.integer()
        val x3 = Arbitrary.integer()

        // when
        val actual = Tetray(x0, x1, x2, x3)

        // then
        val expected = Tetray(x0.toULong(), x1.toULong(), x2.toULong(), x3.toULong())
        assertEquals(expected, actual)
    }

    @Test fun `to string`() {
        // given
        val tetray = Arbitrary.tetray()

        // when
        val actual = tetray.toString()

        // then
        val expected = "${tetray[0]}:${tetray[1]}:${tetray[2]}:${tetray[3]}"
        assertEquals(expected, actual)
    }

    @Test fun `get shell`() {
        // given
        val tetray = Arbitrary.tetray()

        // when
        val actual = tetray.shell

        // then
        val expected = tetray[0] + tetray[1] + tetray[2] + tetray[3]
        assertEquals(expected, actual)
    }

    @Test fun `get coordinate`() {
        // given
        val x0 = Arbitrary.unsignedLong()
        val x1 = Arbitrary.unsignedLong()
        val x2 = Arbitrary.unsignedLong()
        val x3 = Arbitrary.unsignedLong()

        // when
        val tetray = Tetray(x0, x1, x2, x3)

        // then
        assertEquals(x0, tetray[0])
        assertEquals(x1, tetray[1])
        assertEquals(x2, tetray[2])
        assertEquals(x3, tetray[3])
    }

    @Test fun `increment coordinate`() {
        // given
        val x0 = Arbitrary.unsignedLong()
        val x1 = Arbitrary.unsignedLong()
        val x2 = Arbitrary.unsignedLong()
        val x3 = Arbitrary.unsignedLong()
        val initial = List(4) { Tetray(x0, x1, x2, x3) }

        // when
        val actual = initial.mapIndexed { index, tetray -> tetray.increment(index) }

        // expect
        val expected = listOf(
            Tetray(x0 + 1UL, x1, x2, x3),
            Tetray(x0, x1 + 1UL, x2, x3),
            Tetray(x0 , x1, x2 + 1UL, x3),
            Tetray(x0, x1, x2, x3 + 1UL),
        )
        assertEquals(expected, actual)
    }

    @Test fun `decrement coordinate`() {
        // given
        val x0 = Arbitrary.unsignedLong() + 1UL
        val x1 = Arbitrary.unsignedLong() + 1UL
        val x2 = Arbitrary.unsignedLong() + 1UL
        val x3 = Arbitrary.unsignedLong() + 1UL
        val initial = List(4) { Tetray(x0, x1, x2, x3) }

        // when
        val actual = initial.mapIndexed { index, tetray -> tetray.decrement(index) }

        // expect
        val expected = listOf(
            Tetray(x0 - 1UL, x1, x2, x3),
            Tetray(x0, x1 - 1UL, x2, x3),
            Tetray(x0 , x1, x2 - 1UL, x3),
            Tetray(x0, x1, x2, x3 - 1UL),
        )
        assertEquals(expected, actual)
    }
}