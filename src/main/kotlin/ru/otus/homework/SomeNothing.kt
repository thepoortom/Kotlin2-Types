@file:Suppress("UNREACHABLE_CODE")

package ru.otus.homework

fun main() {
    val a: String = badFun()
    val b: Int = badFun()
    val c: MyInt = badFun()
}

fun badFun(): Nothing {
    throw Exception("I'm a bad function")
}
