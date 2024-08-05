@file:Suppress("KotlinConstantConditions")

package ru.otus.homework

fun main() {
    val c1 = SomeClass(1, 2)
    val c2 = c1
    val c3 = SomeClass(1, 2)

    println("c1 == c2: ${c1 == c2}")   // true
    println("c1 === c2: ${c1 === c2}") // true
    println("c1 == c3: ${c1 == c3}")   // true
    println("c1 === c3: ${c1 === c3}")   // false

}

class SomeClass(val a: Int, val b: Int) {
    override fun equals(other: Any?): Boolean {
        println("Running equals")
        val otherSomeClass = other as? SomeClass ?: return false
        return a == otherSomeClass.a && b == otherSomeClass.b
    }

    override fun hashCode(): Int {
        var result = a
        result = 31 * result + b
        return result
    }
}