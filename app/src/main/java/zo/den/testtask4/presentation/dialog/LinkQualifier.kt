package zo.den.testtask4.presentation.dialog

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LinkQualifier(val name: String = "")