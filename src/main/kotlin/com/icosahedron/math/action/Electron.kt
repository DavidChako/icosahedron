package com.icosahedron.math.action

import com.icosahedron.math.Pulse
import com.icosahedron.math.Tetray

data class Electron(val location: Tetray) : Action {
    override fun pulse(): Pulse = Pulse.INWARD
}
