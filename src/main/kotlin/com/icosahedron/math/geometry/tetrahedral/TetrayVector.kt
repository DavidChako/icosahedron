package com.icosahedron.math.geometry.tetrahedral

import com.icosahedron.math.arithmetic.Count

data class TetrayVector(val w: Count, val x: Count, val y: Count, val z: Count) {
    constructor(w: Int, x: Int, y: Int, z: Int): this(Count(w), Count(x), Count(y), Count(z))
    override fun toString() = "$w:$x:$y:$z"
    val shell: Count get() = w + x + y + z
    fun coordinate(direction: TetrayDirection) = direction.project(this)
    fun next(direction: TetrayDirection) = direction.move(this)
}
