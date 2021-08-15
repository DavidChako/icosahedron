package com.icosahedron.math.zzz

import com.icosahedron.math.geometry.tetrahedral.Tetray

data class Proton(val location: Tetray) : Action {
    override fun pulse(): Pulse = Pulse.OUTWARD
}