package com.icosahedron.explore.collections

open class Person(val name: String, val age: Int) {
    override fun toString() = name
}
class Cyborg(name: String): Person(name, 99)

val people = listOf(
    Person("Joe", 15),
    null,
    Person("Agatha", 25),
    null,
    null,
    Person("Amber", 19),
    Cyborg("Rob"),
    null
)

fun main() {
    val randomNames = listOf("Dallas", "Kane", "Ripley", "Lambert")
    println(randomNames.map(String::length))
    println(randomNames.sumOf(String::length))

    val randomNumbers = listOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 6)
    println("sum=${randomNumbers.sum()}, average = ${randomNumbers.average()}")

    val objects = listOf("\uD83D\uDE4F", "\uD83D\uDE04")
    println(objects.take(11))

//    val isUnder18: Person.() -> Boolean = { age < 18 }
//    val (students, discoVisitors) = people.partition(isUnder18)

//    val discoVisitors = people.filterNot { it.isUnder18() }
//    println("discoVisitors: $discoVisitors")
//
//    val students = people.filter { it.isUnder18() }
//    println("students: $students")

    println(people.filterNotNull())
    println(people.filterIsInstance<Cyborg>())

//    val rank = listOf("Gold", "Silver", "Bronze")
//    println(rank.mapIndexed { idx, n -> "$n ($idx)" })
//    val fruits = listOf("Apple", "Banana", "Cherry")
//    for (fruit in fruits) {
//        println(fruit)
//    }
//
//    fruits.forEach { println(it) }
//
//    val stiurf = fruits.map { it.reversed() }
//    println(stiurf)
//
//    val strs = listOf("1", "2", "three", "4", "Y")
//    val nums = strs.mapNotNull { it.toIntOrNull() }
//    println(nums)

//    val aList = listOf("Apple", "Banana", "Cherry")
//    println(aList)
//    println(aList[2])
//
//    val aSet = setOf("Happy", "Curious", "Joyful", "Happy", "Joyful")
//    println(aSet)
//
//    val aMap = mapOf(
//        "Ken" to "Pineapple",
//        "Lou" to "Peperoni",
//        "Ash" to "Ketchup"
//    )
//    println(aMap)
//
}
