package zo.den.testtask4.data

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DataQuailifier(val name: String = "")