package com.icosahedron.test.math

import com.icosahedron.math.Count
import spock.lang.Specification

final class CountSpec extends Specification {
    def "test"() {
        given:
        def count = new Count(31L)

        expect:
        println count

        and:
        println 'hello'
    }

    def "test2"() {
        expect:
        println 'hello2'
    }
}
