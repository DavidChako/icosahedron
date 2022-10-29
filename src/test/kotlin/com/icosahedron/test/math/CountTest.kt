package com.icosahedron.test.math

import com.icosahedron.math.Count
import kotlin.random.Random
import kotlin.random.nextULong
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.full.valueParameters
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CountTest {
    @Test
    fun `is inline ULong`() {
        // given
        val type = Count::class

        // expect
        assertTrue { type.isValue }

        // and
        val params = type.primaryConstructor!!.valueParameters
        assertEquals(1, params.size)
        assertEquals(ULong::class, params.first().type.classifier)

        println((-31).toULong())

        val count: Count = Count(2) + Count(3)
        println(count)
    }

    @Test
    fun `construct from ULong`() {
        // given
        val value = Random.nextULong()

        // when
        val count = Count(value)

        // then
        assertEquals(value, count.value)
    }

    @Test
    fun `construct from Int`() {
        // given
        val value = Random.nextInt()

        // when
        val count = Count(value)

        // then
        assertEquals(value.toULong(), count.value)
    }

//    @ParameterizedTest(name = "construct from ULong")
//    @ValueSource(strings = ["David", "Maggie", "World"])
//    fun `say hello to`(target: String) {
//        // given
//        val hello = Hello(target)
//
//        // when
//        val logRecord = LogRecord(Hello::class, Level.DEBUG)
//        val message = logRecord.capture { hello.sayHello() }
//
//        // then
//        val expectedMessage = "Hello $target!"
//        assertEquals(expectedMessage, message)
//
//        // and
//        val expectedLogMessage = "[DEBUG] Saying hello to $target"
//        assertEquals(1, logRecord.size)
//        assertEquals(expectedLogMessage, logRecord.firstMessage)
//    }
}