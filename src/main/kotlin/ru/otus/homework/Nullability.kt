@file:Suppress("KotlinConstantConditions", "RedundantNullableReturnType")

package ru.otus.homework

fun main() {
    val str1: String = "Hello, World!"
    val str2: String? = null

    println(str1.length.plus(1).minus(1)) // 13
    println(str2?.length?.plus(1)?.minus(1)) // null
}