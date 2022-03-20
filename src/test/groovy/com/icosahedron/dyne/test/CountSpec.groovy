package com.icosahedron.dyne.test

import com.icosahedron.common.random.KotlinRandomGenerator
import com.icosahedron.common.Count
import spock.lang.Specification

final class CountSpec extends Specification {
    def randomGenerator = new KotlinRandomGenerator()

    def "construct from BigInteger"() {
        given:
        def value = randomGenerator.nextInt(0, Integer.MAX_VALUE).toBigInteger()

        when:
        def count = new Count(value)

        then:
        count.value == value
    }

    def "construct from Int"() {
        given:
        def value = randomGenerator.nextInt(0, Integer.MAX_VALUE)

        when:
        def count = new Count(value)

        then:
        count == new Count(value.toBigInteger())
    }

    def "fail init if count is negative"() {
        given:
        def value = randomGenerator.nextInt(Integer.MIN_VALUE, 0)

        when:
        new Count(value)

        then:
        def expected = thrown(IllegalArgumentException)
        expected.cause == null
        expected.message == 'Value=' + value + ' is negative'
    }

    def "to string"() {
        given:
        def value = randomGenerator.nextInt(0, Integer.MAX_VALUE)

        when:
        def count = new Count(value)

        then:
        count.toString() == Integer.toString(value)
    }

    def "plus"() {
        given:
        def value = 0 //randomGenerator.nextInt(0, Integer.MAX_VALUE)
        def addend = 0 //randomGenerator.nextInt(0, Integer.MAX_VALUE)

        when:
        def count = new Count(value) + new Count(addend)

        then:
        count == new Count(value + addend)
    }

    def "plus one"() {
        given:
        def value = randomGenerator.nextInt(0, Integer.MAX_VALUE)

        when:
        def count = new Count(value).plusOne()

        then:
        count == new Count(value + BigInteger.ONE)
    }

    def "minus one"() {
        given:
        def value = randomGenerator.nextInt(1, Integer.MAX_VALUE)

        when:
        def count = new Count(value).minusOne()

        then:
        count == new Count(value - BigInteger.ONE)
    }

    def "minus one throws if value is zero"() {
        given:
        def value = 0

        when:
        new Count(value).minusOne()

        then:
        def expected = thrown(IllegalStateException)
        expected.cause == null
        expected.message == 'Unable to subtract from zero'
    }
}
