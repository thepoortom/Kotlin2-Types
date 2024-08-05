@file:Suppress("KotlinConstantConditions", "RedundantNullableReturnType")

package ru.otus.homework

fun main() {
    printIfNotNull(null)
    printDefaultIfNull(null)
    throwIfNull(null)
}

fun printIfNotNull(str: String?) {
    val nonNull = str ?: return
    println(nonNull)
}

fun printDefaultIfNull(str: String?) {
    val nonNull = str ?: "Default"
    println(nonNull)
}

fun throwIfNull(str: String?) {
    val nonNull = str ?: throw IllegalStateException("String must not be null")
    println(nonNull)
}