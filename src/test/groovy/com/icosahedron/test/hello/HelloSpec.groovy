package com.icosahedron.test.hello

import ch.qos.logback.classic.Level
import com.icosahedron.core.LogRecord
import com.icosahedron.core.TypeManifest
import com.icosahedron.hello.Hello
import spock.lang.Specification

final class HelloSpec extends Specification {
    def "constructor"() {
        def target = 'David'

        def expectedManifest = TypeManifest.expected(Hello, [
                target: target
        ])

        when:
        def hello = new Hello(target)

        then:
        def manifest = TypeManifest.of(hello)
        println manifest
        manifest == expectedManifest
    }

    def "say hello to #target"() {
        given:
        def hello = new Hello(target)

        when:
        def logRecord = new LogRecord(Hello, Level.DEBUG)
        def message = logRecord.capture { hello.sayHello() }

        then:
        message == 'Hello ' + target + '!'

        and:
        logRecord.size == 1
        logRecord.firstMessage == '[DEBUG] Saying hello to ' + target

        and:
        println message

        where:
        target << [ 'David', 'Maggie' ]
    }
}
