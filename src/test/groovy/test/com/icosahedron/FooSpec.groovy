package test.com.icosahedron

import com.icosahedron.Foo
import spock.lang.Specification

final class FooSpec extends Specification {
    def "test"() {
        given:
        def count = new Foo(31L)

        expect:
        println count

        and:
        println 'hello'
    }
}
