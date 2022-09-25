package com.icosahedron.hello

import mu.KLogger
import mu.KotlinLogging

class Hello(private val target: String) {
    fun sayHello(): String {
        LOG.debug("Saying hello to {}", target)
        return "Hello $target!"
    }

    companion object {
        private val LOG: KLogger = KotlinLogging.logger {}
    }
}
