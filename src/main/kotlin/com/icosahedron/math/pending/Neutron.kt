package com.icosahedron.math.pending

import com.icosahedron.math.action.Electron
import com.icosahedron.math.action.Proton

data class Neutron(val proton: Proton, val electron: Electron)
