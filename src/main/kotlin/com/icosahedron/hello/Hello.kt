package com.icosahedron.hello

import com.icosahedron.core.ExcludeFromJacocoGeneratedReport
import mu.KotlinLogging

private val LOG = KotlinLogging.logger @ExcludeFromJacocoGeneratedReport {}
class Hello(private val target: String) {
    fun sayHello(): String {
        LOG.debug("Saying hello to {}", target)
        return "Hello $target!"
    }
}
