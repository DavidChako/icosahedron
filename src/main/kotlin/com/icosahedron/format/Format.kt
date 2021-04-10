package com.icosahedron.format

object Format {
    fun blockBegin(title: String) = blockBoundary(title, "BEGIN")
    fun blockEnd(title: String) = blockBoundary(title, "END")
    private fun blockBoundary(title: String, tag: String, sigil: String="***" ) = "$sigil $tag: $title $sigil"
}