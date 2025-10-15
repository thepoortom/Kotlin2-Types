package ru.otus.homework

/**
 * Common shape
 */
open class Shape {
    open fun draw() {
        println("Drawing a shape")
    }
}

/**
 * Circle shape
 */
class Circle(val radius: Int) : Shape() {
    override fun draw() {
        println("Drawing a circle of radius $radius")
    }
}
