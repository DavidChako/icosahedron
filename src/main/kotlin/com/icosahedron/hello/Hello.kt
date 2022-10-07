package com.icosahedron.hello

import mu.KotlinLogging

private val LOG = KotlinLogging.logger {}
class Hello(private val target: String) {
    fun sayHello(): String {
        LOG.debug("Saying hello to {}", target)
        return "Hello $target!"
    }
}
