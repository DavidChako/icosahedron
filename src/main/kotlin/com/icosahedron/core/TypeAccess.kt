package com.icosahedron.core

import java.lang.reflect.Field
import java.lang.reflect.Modifier

object TypeAccess {
    private enum class Tag { GET, SET }

    @JvmStatic
    fun <T> fields(
        type: Class<T>
    ): List<Field> = type.declaredFields.filter { !Modifier.isStatic(it.modifiers) }

    @JvmStatic
    fun value(
        field: Field,
        source: Any
    ): Any? = operation(Tag.GET, field, source) { it.get(source) }

    @JvmStatic
    fun <V> value(
        source: Any,
        fieldName: String,
        valueType: Class<V>
    ): V = operation(Tag.GET, source.javaClass, source, fieldName) { valueType.cast(it.get(source)) }

    @JvmStatic
    fun <T, V> staticValue(
        type: Class<T>,
        fieldName: String,
        valueType: Class<V>
    ): V = operation(Tag.GET, type, null, fieldName) { valueType.cast(it.get(null)) }

    @JvmStatic
    fun setValue(
        field: Field,
        source: Any,
        value: Any?
    ): Unit = operation(Tag.SET, field, source) { it.set(source, value) }

    @JvmStatic
    fun setValue(
        source: Any,
        fieldName: String,
        value: Any?
    ): Unit = operation(Tag.SET, source.javaClass, source, fieldName) { it.set(source, value) }

    @JvmStatic
    fun <T> setStaticValue(
        type: Class<T>,
        fieldName: String,
        value: Any?
    ): Unit = operation(Tag.SET, type, null, fieldName) { it.set(null, value) }

    private fun <T, V> operation(
        tag: Tag,
        sourceType: Class<T>,
        source: Any?,
        fieldName: String,
        operation: (field: Field) -> V
    ): V = operation(tag, sourceType.getDeclaredField(fieldName), source, operation)

    private fun <V> operation(
        tag: Tag,
        field: Field,
        source: Any?,
        operation: (field: Field) -> V
    ): V = with (field) {
        val fieldIsNotAccessible = !isAccessible

        try {
            if (fieldIsNotAccessible) isAccessible = true
            return operation(field)
        } catch (cause: Throwable) {
            throw IllegalStateException("Failed to $tag value of field $name from source of type $type: $source", cause)
        } finally {
            if (fieldIsNotAccessible) isAccessible = false
        }
    }

// Maybe useful later
//    val staticFields get() = type.declaredFields.filter { Modifier.isStatic(it.modifiers) }
//    val nonJacocoFields get() = fields.filter { it.name != "\$jacocoData" }
//
//    val methods get() = type.declaredMethods.filter { !Modifier.isStatic(it.modifiers) }
//    val staticMethods get() = type.declaredMethods.filter { Modifier.isStatic(it.modifiers) }
//    val nonJacocoMethods get() = methods.filter { it.name != "\$jacocoData" }
}