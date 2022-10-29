package com.icosahedron.math

@JvmInline
value class Circle(val frequency: Count) {
    //constructor(frequency: ULong): this(Count(frequency))
    constructor(frequency: Int): this(Count(frequency))
}