package zo.den.testtask4.exceptions


fun <T> T?.throwIfNull(): T {
    return this ?: throw NoLinkException()
}