package com.icosahedron.dyne.test

import com.icosahedron.common.BigCount
import com.icosahedron.common.Tetray
import com.icosahedron.common.random.KotlinRandomGenerator
import spock.lang.Specification

class TetraySpec extends Specification {
    def randomGenerator = new KotlinRandomGenerator()

//    def n0 = randomGenerator.nextInt(0, Int.MAX_VALUE)
//    private val n1 = Random.nextInt(0, Int.MAX_VALUE)
//    private val n2 = Random.nextInt(0, Int.MAX_VALUE)
//    private val n3 = Random.nextInt(0, Int.MAX_VALUE)
//
//    private val x0 = BigCount(n0)
//    private val x1 = BigCount(n1)
//    private val x2 = BigCount(n2)
//    private val x3 = BigCount(n3)

    def "fail init if array size is not four"() {
        given:
        def array = (1..arraySize).collect { randomGenerator.nextLong() }

        when:
        new Tetray(array)

        then:
        def expected = thrown(IllegalArgumentException)
        expected.cause == null
        expected.message == 'Value=' + value + ' is negative'

        where:
        arraySize << (1..10).collect { it } - [4]
    }


    @Test fun `tetray equals`() {
        assertEquals(Tetray(n0, n1, n2, n3), Tetray(n0, n1, n2, n3))
        assertNotEquals(Tetray(n0+1, n1, n2, n3), Tetray(n0, n1, n2, n3))
    }

    @Test fun `construct from Ints`() {
        val tetray = CountTetray(n0, n1, n2, n3)
        assertEquals(CountTetray(x0, x1, x2, x3), tetray)
    }

    @Test fun `shell is sum of components`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals(x0 + x1 + x2 + x3, tetray.shell())
    }

    @Test fun `to string`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals("$x0:$x1:$x2:$x3", tetray.toString())
    }

    @Test fun `get at index`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals(tetray[0], x0)
        assertEquals(tetray[1], x1)
        assertEquals(tetray[2], x2)
        assertEquals(tetray[3], x3)

        val invalidIndex = 4
        val expectedException = assertFailsWith(ArrayIndexOutOfBoundsException::class) {
            tetray[invalidIndex]
        }

        assertEquals(invalidIndex.toString(), expectedException.message)
    }

    @Test fun `increment at index`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals(CountTetray(x0.plusOne(), x1, x2, x3), tetray.increment(0))
        assertEquals(CountTetray(x0, x1.plusOne(), x2, x3), tetray.increment(1))
        assertEquals(CountTetray(x0, x1, x2.plusOne(), x3), tetray.increment(2))
        assertEquals(CountTetray(x0, x1, x2, x3.plusOne()), tetray.increment(3))

        val invalidIndex = 4
        val expectedException = assertFailsWith(ArrayIndexOutOfBoundsException::class) {
            tetray[invalidIndex]
        }

        assertEquals(invalidIndex.toString(), expectedException.message)
    }

    @Test fun `decrement at index`() {
        val tetray = CountTetray(x0, x1, x2, x3)
        assertEquals(CountTetray(x0.minusOne(), x1, x2, x3), tetray.decrement(0))
        assertEquals(CountTetray(x0, x1.minusOne(), x2, x3), tetray.decrement(1))
        assertEquals(CountTetray(x0, x1, x2.minusOne(), x3), tetray.decrement(2))
        assertEquals(CountTetray(x0, x1, x2, x3.minusOne()), tetray.decrement(3))

        val invalidIndex = 4
        val expectedException = assertFailsWith(ArrayIndexOutOfBoundsException::class) {
            tetray[invalidIndex]
        }

        assertEquals(invalidIndex.toString(), expectedException.message)
    }
}