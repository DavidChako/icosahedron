package com.icosahedron.example

import com.google.gson.Gson
import com.google.gson.GsonBuilder

private object TypeAdjunct {
    val GSON: Gson = Gson()
    val PRETTY_GSON: Gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()
}

fun <T> T.jsonString(): String = TypeAdjunct.GSON.toJson(this)
fun <T> T.prettyJsonString(): String = TypeAdjunct.PRETTY_GSON.toJson(this)
fun <K,V> Map<K,V>.toStandardString(): String = this.toString()