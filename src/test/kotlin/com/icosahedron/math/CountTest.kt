package com.icosahedron.math

import com.icosahedron.test.GenerateRandom
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CountTest {
    @Test fun `fail init on attempt to construct from negative value`() {
        val negativeValue = GenerateRandom.negative()
        val expected = assertFailsWith(IllegalArgumentException::class) { Count(negativeValue) }
        assertEquals("Negative value: $negativeValue", expected.message)
    }

    @Test fun `construct from Int`() {
        val wholeInt = GenerateRandom.wholeInt()
        assertEquals(Count(wholeInt.toBigInteger()), Count(wholeInt))
    }

    @Test fun `construct from Long`() {
        val wholeLong = GenerateRandom.wholeLong()
        assertEquals(Count(wholeLong.toBigInteger()), Count(wholeLong))
    }

    @Test fun `construct from Int is consistent with construct from Long`() {
        val wholeInt = GenerateRandom.wholeInt()
        assertEquals(Count(wholeInt.toLong()), Count(wholeInt))
    }

    @Test fun `to string`() {
        val value = GenerateRandom.whole()
        assertEquals(value.toString(), Count(value).toString())
    }

    @Test fun `operator plus`() {
        val value = GenerateRandom.whole()
        val addend = GenerateRandom.whole()
        assertEquals(Count(value + addend), Count(value) + Count(addend))
    }
}
