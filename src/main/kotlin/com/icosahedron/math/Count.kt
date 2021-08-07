package com.icosahedron.math

data class Count(val count: Long) {
    init {
        require(count >= 0) {
            "Invalid count: $count"
        }
    }

    constructor(count: Int): this(count.toLong())
    override fun toString() = count.toString()
    fun increment() = Count(count + 1)
    fun minus(rhs: Count) = Count(count - rhs.count)
}
