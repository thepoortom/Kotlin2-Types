package ru.otus.homework

fun main() {
    val demo1 = Demo("Hello")
    println(demo1.value)
    val demo2 = Demo("World")
    println(demo2.value)

    demo1.print()
    demo1.prefix = "Начало"
    demo1.postfix = "Конец!"
    demo1.print()

    println(demo1.timesCalled)

    val demo3 = demo1 + demo2
    val (prefix, value, postfix) = demo3
    println("Prefix: $prefix, value: $value, postfix: $postfix")
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

    // Свойство. Доступно снаружи класса для чтения
    val firstChar: Char = value[0]

    // Свойство. Доступно снаружи класса для чтения и записи
    var postfix: String = "Fin!"

    // Cвойство. Доступно только изнутри класса
    private var _prefix: String = "Value"
    // Свойство c геттером и сеттером. Доступно снаружи класса для чтения и записи
    // Используем свойство _prefix для хранения значения
    var prefix: String
        get() = "$_prefix:"
        set(value) { _prefix = value.takeIf { it.isNotBlank() } ?: "Value"}

    // Свойство. Доступно снаружи класса для чтения и изнутри - для записи
    var timesCalled: Int = 0
        private set

    // Метод, доступный изнутри класса
    private fun lastChar(): Char = value[value.length - 1]

    // Метод, доступный извне класса
    fun print() {
        timesCalled++
        println("$prefix $value, first char: $firstChar, last char: ${lastChar()}, postfix: $postfix")
    }

    // Оператор 'plus' для сложения двух объектов класса Demo
    operator fun plus(other: Demo): Demo = Demo(value + " " + other.value).apply {
        prefix = this@Demo._prefix
        postfix = this@Demo.postfix
    }

    // Оператор 'componentX' для деструктуризации объекта класса Demo
    operator fun component1(): String = _prefix
    operator fun component2(): String = value
    operator fun component3(): String = postfix
}