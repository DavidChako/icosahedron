package com.icosahedron.dyne

import java.math.BigInteger
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CountTest {
    @Test fun `fail init if count is negative`() {
        val count = Random.nextInt(Int.MIN_VALUE, 0)
        assertFailsWith(IllegalArgumentException::class) { Count(count) }
    }

    @Test fun `construct from Int`() {
        val value = Random.nextInt(0, Int.MAX_VALUE)
        assertEquals(Count(value.toBigInteger()), Count(value))
    }

    @Test fun `to string`() {
        val value =  Random.nextInt(0, Int.MAX_VALUE)
        assertEquals(value.toString(), Count(value).toString())
    }

    @Test fun `operator plus`() {
        val value = Random.nextInt(0, Int.MAX_VALUE).toBigInteger()
        val addend = Random.nextInt(0, Int.MAX_VALUE).toBigInteger()
        assertEquals(Count(value + addend), Count(value) + Count(addend))
    }

    @Test fun `operator plus one`() {
        val value = Random.nextInt(0, Int.MAX_VALUE).toBigInteger()
        assertEquals(Count(value + BigInteger.ONE), Count(value).plusOne())
    }

    @Test fun `operator minus one`() {
        val value = Random.nextInt(1, Int.MAX_VALUE).toBigInteger()
        assertEquals(Count(value - BigInteger.ONE), Count(value).minusOne())
        assertFailsWith(java.lang.IllegalStateException::class) { Count(0).minusOne() }
    }
}