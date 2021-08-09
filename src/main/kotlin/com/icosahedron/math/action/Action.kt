package com.icosahedron.math.action

import com.icosahedron.math.Pulse

sealed interface Action {
    fun pulse(): Pulse
//    fun location(): Tetray
//    fun inertia(): Tetray
}