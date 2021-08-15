package com.icosahedron.math.arithmetic

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CountTest {
    @Test fun `fail init on attempt to construct from negative value`() {
        val negativeValue = Arbitrary.negative()
        val expected = assertFailsWith(IllegalArgumentException::class) { Count(negativeValue) }
        assertEquals("Negative value: $negativeValue", expected.message)
    }

    @Test fun `construct from Int`() {
        val wholeInt = Arbitrary.wholeInt()
        assertEquals(Count(wholeInt.toBigInteger()), Count(wholeInt))
    }

    @Test fun `to string`() {
        val value = Arbitrary.whole()
        assertEquals(value.toString(), Count(value).toString())
    }

    @Test fun `operator plus`() {
        val value = Arbitrary.whole()
        val addend = Arbitrary.whole()
        assertEquals(Count(value + addend), Count(value) + Count(addend))
    }
}
