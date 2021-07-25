package com.icosahedron.test

import kotlin.reflect.KClass

object Manifest {
    const val NULL_AS_STRING = "null"

    fun of(item: Any) = of(item, true)
    fun of(item: Any, terminalTypes: Set<KClass<Any>>) = of(item, terminalTypes, false)
    fun of(item: Any, includeSupertype: Boolean) = of(item, setOf(), includeSupertype)

    fun of(item: Any?, terminalTypes: Set<KClass<Any>>, includeSupertype: Boolean) : String {
        if (item == null) return NULL_AS_STRING

        val hierarchy = generateHierarchy(item, terminalTypes, includeSupertype)
        val type = item::class

        return if (typeIsEnum(type)) {
            "foo"
        } else {
            "bar"
        }
    }
}