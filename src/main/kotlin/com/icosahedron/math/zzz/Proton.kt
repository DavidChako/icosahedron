package com.icosahedron.math.zzz

import com.icosahedron.math.geometry.tetrahedral.TetrayVector

data class Proton(val location: TetrayVector) : Action {
    override fun pulse(): Pulse = Pulse.OUTWARD
}