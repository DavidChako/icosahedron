package com.icosahedron.math

import com.icosahedron.test.RandomGen
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CountTest {
    @Test fun `fail init if count is negative`() {
        val count = RandomGen.intCount().toBigInteger().negate()

        val expectedException = assertFailsWith(IllegalArgumentException::class) {
            Count(count)
        }

        val actualExceptionMessage = expectedException.message
        val expectedExceptionMessage = "Invalid count: $count"
        assertEquals(expectedExceptionMessage, actualExceptionMessage)
    }

    @Test fun `construct from Int`() {
        val count = RandomGen.intCount()
        val actualCount = Count(count)
        val expectedCount = Count(count.toBigInteger())
        assertEquals(expectedCount, actualCount)
    }

    @Test fun `construct from Long`() {
        val count = RandomGen.longCount()
        val actualCount = Count(count)
        val expectedCount = Count(count.toBigInteger())
        assertEquals(expectedCount, actualCount)
    }

    @Test fun `construct from Int is consistent with construct from Long`() {
        val count = RandomGen.intCount()
        val actualCount = Count(count)
        val expectedCount = Count(count.toLong())
        assertEquals(expectedCount, actualCount)
    }

    @Test fun `to string`() {
        val count = RandomGen.intCount()
        val actualString = Count(count).toString()
        val expectedString = count.toString()
        assertEquals(expectedString, actualString)
    }
}
