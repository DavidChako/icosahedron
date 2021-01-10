package test.com.icosahedron

import com.icosahedron.CountKt
import spock.lang.Specification

final class CountSpec extends Specification {
    def "test"() {
        given:
        def count = CountKt.valueOf(31)

        expect:
        println count

        and:
        println 'hello'
    }
}
