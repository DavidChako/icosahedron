package test.com.icosahedron

import com.icosahedron.Count
import spock.lang.Specification

final class CountSpec extends Specification {
    def countType = BigInteger

    def "Count using BigInteger"() {
        given:
        def value = 31

        when:
        def count = Count.of(value.toInteger())

        then:
        count.class == countType
        count == countType.valueOf(value)
        println count.toString()
        count.toString() == value.toString()
    }
}
