@file:Suppress("unused", "UnusedVariable")

package ru.otus.homework

import java.util.stream.IntStream

fun main() {
    class Box<T>(private val value: T) where T : CharSequence?, T : FirstChar? {
        fun getValue(): T = value
        fun getLength(): Int = value?.length ?: 0
        fun getFirstChar(): Char? = value?.firstChar
    }

    val strBox: Box<MyString> = Box(MyString("String 1"))
    val nStrBox: Box<MyString?> = Box(null)

    val strValue: CharSequence = strBox.getValue()
    val nStrValue: CharSequence? = nStrBox.getValue()
}

data class MyString(val value: String): CharSequence by value, FirstChar {
    override val firstChar: Char get() = value[0]

    override fun chars(): IntStream {
        return value.chars()
    }

    override fun codePoints(): IntStream {
        return value.codePoints()
    }
}

private interface FirstChar {
    val firstChar: Char
}
