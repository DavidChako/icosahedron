package com.icosahedron.explore.strings

import java.io.File

fun main() {
    val input = "Hello, World!"
    println(input[1])
    println(input.filter { it.isUpperCase() })
//    val input = """
//        Well this is crazy
//        I'm a multiline string
//        So split me maybe?
//    """.trimIndent()
//    println(input.lines())

//    val input = "A; B; C; D; E"
//    println(input.split("; ", limit = 3))

//    val input = "QuiCK BrOWN FoX"
//    println(input.equals("Quick Brown Fox", ignoreCase = true))

//    println("a" < "b")
//    println("a" > "c")

//    val stringA = "astring"
//    if (stringA == "astring") {
//        println("Everything cool!")
//    }

//    val input = "   ***##valuable info%%*** "
//    println(input.trim().removeSurrounding("***").removePrefix("##").removeSuffix("%%"))

//    val neverBlankString = " ".ifBlank {
//        "Never blank!"
//    }
//
//    println(neverBlankString)
//    println("   \n\t   ".isBlank())
//    println("".isEmpty())

//    val name = "David"
//    val myString = buildString {
//        repeat(10) {
//            append("Hello, ")
//            append(name)
//            appendLine("!")
//        }
//    }
//    println(myString)

//    val name: String = File("/Users/davidchako/codes/icosahedron/src/main/resources/NameInput.txt").readText()
//    val name: String? = readLine()
//    val name = "David"
//    val name = """
//        David
//        The Polymath
//        The "Icosahedron"
//        """.trimIndent()
//
//    println("Hello $name")
//    println("Your name is ${name!!.count()} characters long")
}
