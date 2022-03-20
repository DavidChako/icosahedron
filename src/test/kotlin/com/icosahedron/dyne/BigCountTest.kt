package com.icosahedron.dyne

import com.icosahedron.common.BigCount
import java.math.BigInteger
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BigCountTest {
    @Test fun `fail init if count is negative`() {
        val count = Random.nextInt(Int.MIN_VALUE, 0)
        assertFailsWith(IllegalArgumentException::class) { BigCount(count) }
    }

    @Test fun `construct from Int`() {
        val value = Random.nextInt(0, Int.MAX_VALUE)
        assertEquals(BigCount(value.toBigInteger()), BigCount(value))
    }

    @Test fun `to string`() {
        val value =  Random.nextInt(0, Int.MAX_VALUE)
        assertEquals(value.toString(), BigCount(value).toString())
    }

    @Test fun `operator plus`() {
        val value = Random.nextInt(0, Int.MAX_VALUE).toBigInteger()
        val addend = Random.nextInt(0, Int.MAX_VALUE).toBigInteger()
        assertEquals(BigCount(value + addend), BigCount(value) + BigCount(addend))
    }

    @Test fun `operator plus one`() {
        val value = Random.nextInt(0, Int.MAX_VALUE).toBigInteger()
        assertEquals(BigCount(value + BigInteger.ONE), BigCount(value).plusOne())
    }

    @Test fun `operator minus one`() {
        val value = Random.nextInt(1, Int.MAX_VALUE).toBigInteger()
        assertEquals(BigCount(value - BigInteger.ONE), BigCount(value).minusOne())
        assertFailsWith(java.lang.IllegalStateException::class) { BigCount(0).minusOne() }
    }
}