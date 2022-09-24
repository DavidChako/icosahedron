package com.icosahedron.test

import kotlin.reflect.KClass

object Manifest {
    fun of(item: Any) = of(item, true)
    fun of(item: Any, terminalTypes: Set<KClass<Any>>) = of(item, terminalTypes, false)
    fun of(item: Any, includeSupertype: Boolean) = of(item, setOf(), includeSupertype)

    fun of(item: Any?, terminalTypes: Set<KClass<Any>>, includeSupertype: Boolean) : String {
        item?.let {
            return ofNotNull(it, terminalTypes, includeSupertype)
        } ?:run {
            return "null"
        }
    }

    private fun ofNotNull(item: Any, terminalTypes: Set<KClass<Any>>, includeSupertype: Boolean) : String {
        val typeName = inferTypeName(item)
        val hierarchy = generateHierarchy(item, terminalTypes, includeSupertype)
        val hierarchyJson = prettyJson(hierarchy)
        return typeName + '\n' + hierarchyJson
    }

    private fun inferTypeName(item: Any) = if (Enum::class.isInstance(item)) {
        "enum"
    } else {
        "non enum"
    }
}
