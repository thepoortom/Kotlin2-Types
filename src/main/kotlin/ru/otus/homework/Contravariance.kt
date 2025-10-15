@file:Suppress("RedundantExplicitType", "UnusedVariable", "unused")

package ru.otus.homework

fun main() {
    val circle: Circle = Circle(10)
    val shape: Shape = circle

    val cc: Contravariance<Circle> = Contravariance()
    val sc: Contravariance<Shape> = Contravariance()

    // Valid as Contravariance<Shape> is a subtype of Contravariance<Circle>
    // and we only consume the value, not produce it
    val scAsCc: Contravariance<Circle> = sc
}

class Contravariance<in T: Shape> {
    /**
     * Method CONSUMES the value
     */
    fun design(shape: T) {
        shape.draw()
    }
}