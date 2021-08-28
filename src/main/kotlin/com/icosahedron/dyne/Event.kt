package com.icosahedron.dyne

data class Event(val location: Tetray, val inertia: Tetray) {
    fun shell() = location.sum()
    fun frequency() = inertia.sum()
    fun weight(n: Int) = inertia[n]
    fun move(n: Int) = location.increment(n)

    fun accelerate(from: Int, to: Int) {
        inertia.decrement(from)
        inertia.increment(to)
    }
}