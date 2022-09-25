package com.icosahedron.example

fun <T> Collection<T>.powerSet(): Set<Set<T>> {
    tailrec fun<T> powerSet(left: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> =
        if (left.isEmpty()) acc else powerSet(left.drop(1), acc + acc.map { it + left.first() })

    return powerSet(this, setOf(emptySet()))
}