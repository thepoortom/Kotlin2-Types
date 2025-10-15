package ru.otus.homework

fun main() {
    val demo1 = Demo("Hello")
    println(demo1.value)
    val demo2 = Demo("World")
    println(demo2.value)
}

// В скобках после имени класса указывается конструктор, который принимает строку
class Demo(value: String) : Any() {
    // Свойство. Доступно только для чтения
    val value: String

    // Блок инициализации. Выполняется при создании объекта
    init {
        if (value.isBlank()) {
            throw IllegalStateException("Value must not be blank")
        }
        // Инициализируем свойство value значением, переданным в конструктор
        this.value = value
    }
}