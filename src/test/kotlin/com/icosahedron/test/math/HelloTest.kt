package com.icosahedron.test.math

import ch.qos.logback.classic.Level
import com.icosahedron.core.LogRecord
import com.icosahedron.core.TypeManifest
import com.icosahedron.hello.Hello
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloTest {
    @Test
    fun `construct Hello`() {
        // given
        val target = "David"

        // when
        val hello = Hello(target)

        // then
        val manifest = TypeManifest.of(hello)
        val expectedManifest = TypeManifest.expected(Hello::class, mapOf("target" to target))
        assertEquals(expectedManifest, manifest)
    }

    @ParameterizedTest(name = "say hello to {0}")
    @ValueSource(strings = ["David", "Maggie", "World"])
    fun `say hello to`(target: String) {
        // given
        val hello = Hello(target)

        // when
        val logRecord = LogRecord(Hello::class, Level.DEBUG)
        val message = logRecord.capture { hello.sayHello() }

        // then
        val expectedMessage = "Hello $target!"
        assertEquals(expectedMessage, message)

        // and
        val expectedLogMessage = "[DEBUG] Saying hello to $target"
        assertEquals(1, logRecord.size)
        assertEquals(expectedLogMessage, logRecord.firstMessage)
    }

//    @Test fun `operator minus one`() {
//        val value = Random.nextInt(1, Int.MAX_VALUE).toBigInteger()
//        assertEquals(BigCount(value - BigInteger.ONE), BigCount(value).minusOne())
//        assertFailsWith(java.lang.IllegalStateException::class) { BigCount(0).minusOne() }
//    }
}