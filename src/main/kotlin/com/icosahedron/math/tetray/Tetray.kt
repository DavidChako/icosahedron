package com.icosahedron.math.tetray

import com.icosahedron.math.Count

data class Tetray(val w: Count, val x: Count, val y: Count, val z: Count) {
    constructor(w: Int, x: Int, y: Int, z: Int): this(Count(w), Count(x), Count(y), Count(z))
    override fun toString() = "$w:$x:$y:$z"
    val shell: Count get() = w + x + y + z
    fun coordinate(direction: Direction) = direction.coordinate(this)
    fun next(direction: Direction) = direction.move(this)
}
