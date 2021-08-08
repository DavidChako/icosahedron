package com.icosahedron.math

data class Tetray(val w: Count, val x: Count, val y: Count, val z: Count) {
    constructor(w: Int, x: Int, y: Int, z: Int): this(Count(w), Count(x), Count(y), Count(z))
    override fun toString() = "$w:$x:$y:$z"
    val shell: Count get() = w + x + y + z
//
//    fun coordinate(ordinate: Int) = coordinates[ordinate]
//
//    fun incrementCoordinate(ordinate: Int) = run {
//        coordinates[ordinate] = coordinate(ordinate) + 1UL
//    }
}
