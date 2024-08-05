package ru.otus.homework

fun main() {
    class Box<T>(val value: T) {
        override fun toString(): String {
            return "Box(value=$value)"
        }
    }

    val intBox: Box<Int> = Box(100500)
    val stringBox: Box<String> = Box("Hello, World!")

    val intValue: Int = intBox.value // 100500
    val stringValue: String = stringBox.value // "Hello, World!"
}
