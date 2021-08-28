package com.icosahedron.dyne

data class Event(val location: Tetray, val inertia: Tetray) {
    fun tick() = location.shell()
    fun weight(n: Int) = inertia[n]
    fun move(n: Int) = location.increment(n)

    fun accelerate(from: Int, to: Int) = if (inertia.decrement(from)) {
        if (inertia.increment(to)) {
            true
        } else {
            inertia.increment(from)
            false
        }
    } else {
        false
    }
}