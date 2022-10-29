package com.icosahedron.test.data

import com.icosahedron.core.TypeRender
import com.icosahedron.data.Event
import java.time.LocalDateTime
import kotlin.test.Test

class EventTest {
    @Test
    fun `explore time`() {
        val days: ULong = 100000UL
        val years: ULong = days / 365UL
        val nanos: ULong = days * 24UL * 60UL * 60UL * 1000UL * 1000UL * 1000UL

        println(years)
        println(days)
        println(nanos)
        println(ULong.MAX_VALUE)
    }

    @Test
    fun `construct Event`() {
        // given
        val whenIngested = LocalDateTime.now()
        val whenRecorded = whenIngested.plusSeconds(60)
        val whenEffective = whenRecorded.plusDays(1)
        val message = "hello"

        // when
        val event = Event(message, whenIngested, whenRecorded, whenEffective)

        // then
        println(event)

        // and
        println(TypeRender.prettyJsonString(event))
    }
}