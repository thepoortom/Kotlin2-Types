package ru.otus.homework

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MyIntTest {
    @Test
    fun `adds two values with plus operator`() {
        assertEquals(3, (MyInt(1) + MyInt(2)).value)
    }
}