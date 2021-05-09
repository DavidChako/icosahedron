package com.icosahedron.explore.compete

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    readLine()
    val rawData = readLine()!!
    println("Raw data: $rawData")

    val data = rawData.split(" ").map {
        it.startsWith("s") to it.drop(1).toInt()
    }
    println("Data: $data")

    val genes = data.map { it.second}.toSet()
    println("Genes: $genes")

    val geneLimit = genes.maxOrNull()!! + 1
    println("Gene limit: $geneLimit")

    val balance = IntArray(geneLimit)
    val minBalance = IntArray(geneLimit)
    val possible = BooleanArray(geneLimit)

    fun impact(gene: Int) = if (possible[gene] && balance[gene] == minBalance[gene]) 1 else 0

    fun process(atZero: Int): List<Int> = data.scan(atZero) { acc, (isStart, gene) ->
        val impactBefore = impact(gene)
        balance[gene] += if (isStart) 1 else -1
        minBalance[gene] = minOf(minBalance[gene], balance[gene])
        acc - impactBefore + impact(gene)
    }

    process(0)
    genes.filter { balance[it] == 0 }.forEach { possible[it] = true}
    val atZero = genes.sumBy { impact(it) }
    val answer = process(atZero).withIndex().maxByOrNull { it.value }!!
    println("${answer.index + 1} ${answer.value}")
}
