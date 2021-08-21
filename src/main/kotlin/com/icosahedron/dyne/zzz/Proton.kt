package com.icosahedron.dyne.zzz

import com.icosahedron.dyne.Tetray

data class Proton(val location: Tetray) : Action {
    override fun pulse(): Pulse = Pulse.OUTWARD
}