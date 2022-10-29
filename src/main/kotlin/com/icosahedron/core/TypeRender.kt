package com.icosahedron.core

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object TypeRender {
    private val PRETTY_GSON: Gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()
    fun <T> prettyJsonString(instance: T?) = instance?.let { it::class.qualifiedName + ' ' + PRETTY_GSON.toJson(instance) } ?: "null"
}
