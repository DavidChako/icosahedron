package com.icosahedron.dyne.zzz

sealed interface Action {
    fun pulse(): Pulse
//    fun location(): Tetray
//    fun inertia(): Tetray
}