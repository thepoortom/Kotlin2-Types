@file:Suppress("unused", "UnusedVariable")

package ru.otus.homework

fun main() {
    val stringBox = LabeledBox("Strings", "Hello, World!")
    val intBox = LabeledBox("Ints", 100500)

    printBoxLabel(stringBox)
    printBoxLabel(intBox)
}

private class LabeledBox<T>(val label: String, private val value: T) {
    fun getValue(): T = value
}

private fun printBoxLabel(box: LabeledBox<*>) {
    println(box.label)
}

