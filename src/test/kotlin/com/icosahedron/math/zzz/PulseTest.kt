package com.icosahedron.math.zzz

import kotlin.test.Test
import kotlin.test.assertEquals

class PulseTest {
    @Test fun `available pulses`() {
        assertEquals(listOf(Pulse.INWARD, Pulse.OUTWARD), Pulse.values().toList())
    }
}