package zo.den.testtask4.presentation.mapper

import kotlin.NoSuchElementException

fun <T> T?.throwIfNull(): T {
    return this ?: throw NoSuchElementException()
}