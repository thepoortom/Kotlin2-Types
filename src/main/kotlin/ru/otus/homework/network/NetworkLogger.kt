@file:Suppress("unused")

package ru.otus.homework.network

import ru.otus.homework.Shape
import java.lang.IllegalArgumentException
import java.time.LocalDateTime

/**
 * Известный вам список ошибок
 */
sealed class ApiException(message: String) : Throwable(message) {
    data object NotAuthorized : ApiException("Not authorized")
    data object NetworkException : ApiException("Not connected")
    data object UnknownException: ApiException("Unknown exception")
}

class ErrorLogger<in E : Throwable> {

    val errors = mutableListOf<Pair<LocalDateTime, Throwable>>()

    fun log(response: NetworkResponse<*, E>) {
        if (response is Failure) {
            errors.add(response.responseDateTime to response.error)
        }
    }

    fun dumpLog() {
        errors.forEach { (date, error) ->
            println("Error at $date: ${error.message}")
        }
    }
}

fun processThrowables(logger: ErrorLogger<Throwable>) {
    logger.log(Success("Success"))
    Thread.sleep(100)
    logger.log(Success(Shape()))
    Thread.sleep(100)
    logger.log(Failure(IllegalArgumentException("Something unexpected")))

    logger.dumpLog()
}

fun processApiErrors(apiExceptionLogger: ErrorLogger<ApiException>) {
    apiExceptionLogger.log(Success("Success"))
    Thread.sleep(100)
    apiExceptionLogger.log(Success(Shape()))
    Thread.sleep(100)
    apiExceptionLogger.log(Failure(ApiException.NetworkException))

    apiExceptionLogger.dumpLog()
}

fun main() {
    val logger = ErrorLogger<Throwable>()

    println("Processing Throwable:")
    processThrowables(logger)

    println("Processing Api:")
    processApiErrors(logger)
}

