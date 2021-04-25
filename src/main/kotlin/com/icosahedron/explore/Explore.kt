package com.icosahedron.explore

data class Customer(var name: String, val email: String, val company: String)

fun main() {
    val customer = Customer("David Chako", "dchako@icosahedron.com", "Icosahedron Design")
    println(customer)

    customer.name = "maggie"
    println(customer)
}
