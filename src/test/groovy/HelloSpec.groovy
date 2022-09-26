

import ch.qos.logback.classic.Level
import com.icosahedron.core.LogRecorder
import com.icosahedron.core.ObjectManifest
import com.icosahedron.hello.Hello
import spock.lang.Specification

final class HelloSpec extends Specification {
    def "constructor"() {
        def target = 'David'

        def expectedManifest = ObjectManifest.expected( Hello, [
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
        String message
        def loggingEvents = LogRecorder.record(Hello, Level.DEBUG) {
            message = hello.sayHello()
        }

        then:
        message != null
        message == 'Hello ' + target + '!'

        and:
        loggingEvents.size() == 1
        loggingEvents.get(0).toString() == '[DEBUG] Saying hello to ' + target

        and:
        println message

        where:
        target << [ 'David', 'Maggie' ]
    }
}
