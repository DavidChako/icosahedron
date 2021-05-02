package com.icosahedron.explore.spring.feature

import java.util.*

fun main() {
    applyAction("hello", "goodbye") { s: String ->
        println("$s --> ${s.uuid()}")
    }
}

fun applyAction(vararg s: String, action: (String) -> Unit) {
    s.forEach(action)
}

fun String.uuid(): String = UUID.nameUUIDFromBytes(encodeToByteArray()).toString()
