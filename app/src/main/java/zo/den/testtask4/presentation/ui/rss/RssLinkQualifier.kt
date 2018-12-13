package zo.den.testtask4.presentation.ui.rss

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RssLinkQualifier (val name: String = "")