package com.icosahedron.explore.compete

fun main() {
    val a = intArrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9)
    val prefixSums = a.scan(0, Int::plus)
    println(prefixSums)

    val arrayOfOnes = IntArray(10) { 1 }.toList()
    println(arrayOfOnes)

    val rowNumbers = arrayOfOnes.scan(0, Int::plus)
    println(rowNumbers)

    val triangleNumbers = rowNumbers.scan(0, Int::plus)
    println(triangleNumbers)

    val tetrahedralNumbers = triangleNumbers.scan(0, Int::plus)
    println(tetrahedralNumbers)

    println(a.mex())
}

private fun IntArray.mex() = (0..size).first { it !in this }