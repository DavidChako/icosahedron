package com.icosahedron.dyne.zzz

import com.icosahedron.dyne.CountTetray

data class Proton(val location: CountTetray) : Action {
    override fun pulse(): Pulse = Pulse.OUTWARD
}