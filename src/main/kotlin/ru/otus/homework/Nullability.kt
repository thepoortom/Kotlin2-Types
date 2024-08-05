@file:Suppress("KotlinConstantConditions", "RedundantNullableReturnType")

package ru.otus.homework

fun main() {
    val str1: String = "Hello, World!"
    val str2: String? = "Hello, Null!"

    // ...
    // Сильно ниже по коду в строке 100500
    // ...
    println(str1.length)
    if (null != str2) {
        println(str2.length)
        println(str2.first())
    }
}