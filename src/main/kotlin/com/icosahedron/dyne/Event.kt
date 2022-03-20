package com.icosahedron.dyne

import com.icosahedron.common.Tetray

data class Event(val location: Tetray, val inertia: Tetray) {
    constructor(event: Event) : this(Tetray(event.location), Tetray(event.inertia))

    override fun toString() = "$inertia@$location"

    fun shell() = location.sum()

    fun frequency() = inertia.sum()

    fun weight(n: Int) = inertia[n]

    fun move(n: Int) = location.increment(n)

    fun accelerate(from: Int, to: Int) {
        inertia.decrement(from)
        inertia.increment(to)
    }
}