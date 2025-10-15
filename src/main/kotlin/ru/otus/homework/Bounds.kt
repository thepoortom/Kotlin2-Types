@file:Suppress("unused", "UnusedVariable")

package ru.otus.homework

fun main() {
    class Box<T>(private val value: T) {
        fun getValue(): T = value
    }

    val strBox: Box<String> = Box("String 1")
    val nStrBox: Box<String?> = Box(null)

    val strValue: String = strBox.getValue()
    val nStrValue: String? = nStrBox.getValue()
}
