@file:Suppress("unused", "UnusedVariable")

package ru.otus.homework

fun main() {
    val stringBox = LabeledBox("Strings", "Hello, World!")
    val intBox = LabeledBox("Ints", 100500)

    printStringBoxLabel(stringBox)
    printIntBoxLabel(intBox)
}

private class LabeledBox<T>(val label: String, private val value: T) {
    fun getValue(): T = value
}

private fun printStringBoxLabel(box: LabeledBox<String>) {
    println(box.label)
}

private fun printIntBoxLabel(box: LabeledBox<Int>) {
    println(box.label)
}

