package com.icosahedron.test.hello

import ch.qos.logback.classic.Level
import com.icosahedron.core.LogSpy
import com.icosahedron.core.ObjectManifest
import com.icosahedron.hello.Hello
import spock.lang.Specification

final class HelloSpec extends Specification {
    def "constructor"() {
        def target = 'David'

        def expectedManifest = ObjectManifest.expected(Hello, [
                target: target
        ])

        when:
        def hello = new Hello(target)

        then:
        def manifest = ObjectManifest.of(hello)
        println manifest
        manifest == expectedManifest
    }

    def "say hello to #target"() {
        given:
        def hello = new Hello(target)

        when:
        def logSpy = new LogSpy(Hello, Level.DEBUG)
        def message = logSpy.capture { hello.sayHello() }

        then:
        message == 'Hello ' + target + '!'

        and:
        logSpy.size == 1
        logSpy.firstMessage == '[DEBUG] Saying hello to ' + target

        and:
        println message

        where:
        target << [ 'David', 'Maggie' ]
    }
}
