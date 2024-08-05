package ru.otus.homework

fun main() {
    val a: String = badStringFun()
    val b: Int = badIntFun()
}

fun badStringFun(): String {
    throw Exception("I'm a bad string function")
}

fun badIntFun(): Int {
    throw Exception("I'm a bad int function")
}