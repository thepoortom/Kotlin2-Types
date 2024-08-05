package ru.otus.homework

class SomeBoxing {
    val a = 5

    fun printHashCode() {
        println(a.hashCode())
    }

    fun doBoxing() {
        boxIt(a)
    }
}

fun boxIt(value: Any) {
    println(value.hashCode())
}