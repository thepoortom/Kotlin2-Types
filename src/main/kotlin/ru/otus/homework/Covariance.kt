@file:Suppress("RedundantExplicitType", "UnusedVariable", "unused")

package ru.otus.homework

fun main() {
    val circle: Circle = Circle(10)
    val shape: Shape = circle

    val cc: Covariance<Circle> = Covariance(Circle(5))
    val sc: Covariance<Shape> = Covariance(Shape())

    // Valid as Covariance<Circle> is a subtype of Covariance<Shape>
    // and we only produce the value, not consume it
    val ccAsSc: Covariance<Shape> = cc
}

class Covariance<out T : Shape>(private val value: T) {
    fun produce(): T {
        return value
    }
}