package ru.otus.homework

import kotlin.random.Random

class MyInt(val value: Int): Any() { // value - это свойство класса (property)
    // Методы преобразования типов
    fun toDouble(): Double = value.toDouble()
    fun toLong(): Long = value.toLong()

    // Перегрузка операторов
    operator fun plus(other: MyInt): MyInt = MyInt(value + other.value)

    // Переопределение методов equals, hashCode и toString
    override fun equals(other: Any?): Boolean {
        return value == (other as? MyInt)?.value
    }
    override fun hashCode(): Int = value
    override fun toString(): String = "MyInt(${value})"

    // Компаньон-объект. Содержит статические свойства и методы
    companion object {
        val MAX_VALUE = MyInt(Int.MAX_VALUE)
        val MIN_VALUE = MyInt(Int.MIN_VALUE)
    }
}

fun main() {
    val i1 = MyInt(Int.MAX_VALUE)
    val i2 = MyInt.MIN_VALUE
    println("i = ${i1.value}") // Обращение к свойству value
    val l = i1.toLong()        // Вызов метода toLong()
    val i3 = i1 + i2           // Вызов переопределенного оператора '+'

    // Декларируемый тип - Any, но фактический тип - MyInt
    val a1: Any = MyInt.MAX_VALUE
    // Явное приведение типа - на ваш страх и риск
    val d = (a1 as MyInt).toDouble()

    // Декларируемый тип - Any, но фактический тип может быть разным
    val a2: Any = if (Random.nextBoolean()) MyInt.MIN_VALUE else 100500L
    // Метод определен в супертипе
    val a2s = a2.toString()
    // Проверяем, является ли переменная экземпляром MyInt
    if (a2 is MyInt) {
        a2.toDouble()
    }
}