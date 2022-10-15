package com.icosahedron.core

import ch.qos.logback.classic.Logger
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Field
import java.time.temporal.Temporal
import java.util.TreeSet
import kotlin.reflect.KClass

object TypeManifest {
    private const val EMPTY_HIERARCHY = "{}"
    private val PRETTY_GSON: Gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()

    @JvmStatic
    @JvmOverloads
    fun of(
        source: Any?,
        terminals: Set<Class<Any>> = setOf(),
        withLineage: Boolean = false
    ): String? {
        if (source == null) return null
        val type = source.javaClass
        val typeName = type.name
        val isEnum = typeIsEnum(type)
        val hierarchy = hierarchy(source, withLineage, terminals)
        val hierarchyString = if (isEnum && hierarchy === source) "" else '\n' + PRETTY_GSON.toJson(hierarchy)
        return if (isEnum) "$typeName.$source$hierarchyString" else "$typeName$hierarchyString"
    }

    @JvmStatic
    @JvmOverloads
    fun expected(
        type: Class<out Any>,
        fields: Map<String, Any>,
        terminals: Set<Class<Any>> = setOf(),
        precursors: HashSet<Any> = HashSet(),
    ): String {
        if (typeIsEnum(type)) {
            throw UnsupportedOperationException("Use overload of expected method with enum value as argument")
        }

        val hierarchy = expectedHierarchy(type, precursors, fields, terminals)
        return type.name + '\n' + PRETTY_GSON.toJson(hierarchy)
    }

    fun expected(
        type: KClass<out Any>,
        fields: Map<String, Any>,
        terminals: Set<Class<Any>> = setOf(),
        precursors: HashSet<Any> = HashSet(),
    ): String = expected(type.java, fields, terminals, precursors)

    private fun hierarchy(
        source: Any?,
        withLineage: Boolean,
        terminals: Set<Class<Any>>,
        precursors: HashSet<Any> = HashSet()
    ): Any? = when {
        source == null -> null
        source.javaClass.simpleName.endsWith("KStreamMap") -> "KStreamMap"
        source.javaClass in terminals -> source.toString()
        typeIsTerminal(source) -> source.toString()
        source is Class<*> -> source.name
        source is Array<*> -> source.map { elementHierarchy(it, terminals, precursors) }
        source is Set<*> -> TreeSet(source).map { elementHierarchy(it, terminals, precursors) }
        source is Collection<*> -> source.map { elementHierarchy(it, terminals, precursors) }

        source is Map<*,*> -> source.entries.filter { it.key != null}.associate { (key, value) ->
            val keyHierarchy = keyHierarchy(key, terminals, precursors)
            val valueHierarchy = elementHierarchy(value, terminals, precursors)
            keyHierarchy to valueHierarchy
        }

        else -> {
            val type = source.javaClass
            val hierarchy = hierarchy(type, source, withLineage, terminals, precursors)
            if (typeIsEnum(type) && hierarchy === EMPTY_HIERARCHY) source else hierarchy
        }
    }

    private fun expectedHierarchy(
        type: Class<out Any>,
        precursors: HashSet<Any>,
        fields: Map<String, Any?>,
        terminals: Set<Class<Any>>
    ): LinkedHashMap<String, Any?> = fields.entries.associateTo(LinkedHashMap()) {(name, value) ->
        val hierarchy = hierarchy(value, false, terminals, precursors)
        val field = type.getDeclaredField(name)
        val key = inferValueKey(field, value)
        key to hierarchy
    }

    private fun hierarchy(
        type: Class<Any>,
        source: Any,
        withLineage: Boolean,
        terminals: Set<Class<Any>>,
        precursors: HashSet<Any> = HashSet()
    ): Any {
        val hierarchy = TypeAccess.fields(type).associateTo(LinkedHashMap()) { field ->
            val value = TypeAccess.value(field, source)
            val valueKey = inferValueKey(field, value)

            val hierarchyValue = when (value) {
                in precursors -> "circular reference"
                else -> {
                    val fieldPrecursors = HashSet(precursors)
                    fieldPrecursors.add(source)
                    hierarchy(value, false, terminals, fieldPrecursors)
                }
            }

            valueKey to hierarchyValue
        }

        if (withLineage && type.superclass != null) {
            hierarchy[type.simpleName + "_supertype"] =
                hierarchy(type.superclass, source, true, terminals, HashSet())
        }

        return if (hierarchy.isEmpty()) EMPTY_HIERARCHY else hierarchy
    }

    private fun keyHierarchy(
        key: Any?,
        terminals: Set<Class<Any>>,
        precursors: HashSet<Any>
    ): Any? {
        if (key == null) return null
        val type = key.javaClass
        return when {
            typeIsEnum(type) -> "enum $key of ${type.simpleName}"
            type in terminals -> key.toString()
            typeIsTerminal(key) -> key.toString()
            else -> hierarchy(type, key, false, terminals, precursors)
        }
    }

    private fun elementHierarchy(
        element: Any?,
        terminals: Set<Class<Any>>,
        precursors: HashSet<Any>
    ): Any? {
        if (element == null) return null
        val type = element.javaClass
        val typeName = type.simpleName
        val isEnum = typeIsEnum(type)
        val hierarchy = hierarchy(element, false, terminals, precursors)
        val key = if (isEnum) "$typeName.$element" else typeName
        return if (isEnum && hierarchy === element) key else mapOf(key to hierarchy)
    }

    private fun typeIsTerminal(
        source: Any
    ): Boolean = source.javaClass.isPrimitive
            || source is Class<*>
            || source is Boolean
            || source is Char
            || source is String
            || source is Number
            || source is Temporal
            || source is Logger

    private fun typeIsEnum(
        type: Class<out Any>
    ): Boolean = type.isEnum || (type.superclass != null && type.superclass.isEnum)

    private fun inferValueKey(
        field: Field,
        value: Any?
    ): String {
        val valueType = value?.javaClass ?: field.type
        val valueTypeName = with(valueType) {
            if (simpleName.startsWith("\$Proxy")) interfaces[0].simpleName else simpleName
        }
        return "$valueTypeName ${field.name}"
    }
}