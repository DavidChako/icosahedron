package com.icosahedron.data

import java.time.LocalDateTime

data class Event<T>(val message: T, val whenIngested: LocalDateTime, val whenRecorded: LocalDateTime, val whenEffective: LocalDateTime)
