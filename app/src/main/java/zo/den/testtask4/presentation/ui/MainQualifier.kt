package zo.den.testtask4.presentation.ui

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainQualifier(val name: String = "")