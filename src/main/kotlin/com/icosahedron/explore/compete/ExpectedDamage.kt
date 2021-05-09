package com.icosahedron.explore.compete

const val M = 998244353

fun main() {
    val (_, shieldCount) = readInts()
    val monsters = readInts().sorted().toMutableList()
    val sumAll = monsters.sumOf { it.toLong() }

    data class Shield(val durability: Int, val defence: Int, val id: Int)
    val shields = List(shieldCount) { id -> readInts().let { Shield(it[0], it[1], id) } }

    var strong = 0 //monsters.count { it >= shield.defence }
    var sumStrong = 0 //monsters.filter { it >= shield.defence }.sumOf { it.toLong() }
    val answers = IntArray(shieldCount)

    for (shield in shields.sortedByDescending { it.defence }) {
        while (monsters.isNotEmpty() && monsters.last() >= shield.defence) {
            strong++
            sumStrong += monsters.removeLast()
        }

        if (strong == 0) continue

        val sumWeak = sumAll - sumStrong
        val pStrong = Modular(maxOf(strong - shield.durability, 0)) / strong
        val pWeak = Modular(maxOf(strong + 1 - shield.durability, 0)) / (strong + 1)
        val expectedDamage = pStrong * (sumStrong % M) + pWeak * (sumWeak % M)
        answers[shield.id] = expectedDamage.toInt()
    }

    println(answers.joinToString("\n"))
}

private fun readInts() = readLine()!!.split(" ").map { it.toInt() }

class Modular(private val value: Int) : Number() {
    operator fun plus(that: Number) = Modular((value + that.toInt()) % M)
    operator fun times(that: Number) = Modular(((value.toLong() * that.toInt()) % M).toInt())
    operator fun div(that: Number) = this * that.toInt().toBigInteger().modInverse(M.toBigInteger())

    override fun toInt(): Int {
        return value
    }

    override fun toByte(): Byte {
        TODO("Not yet implemented")
    }

    override fun toChar(): Char {
        TODO("Not yet implemented")
    }

    override fun toDouble(): Double {
        TODO("Not yet implemented")
    }

    override fun toFloat(): Float {
        TODO("Not yet implemented")
    }

    override fun toLong(): Long {
        TODO("Not yet implemented")
    }

    override fun toShort(): Short {
        TODO("Not yet implemented")
    }

}