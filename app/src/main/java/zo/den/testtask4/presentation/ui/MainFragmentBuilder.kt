package zo.den.testtask4.presentation.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zo.den.testtask4.presentation.ui.rss.RssFragment
import zo.den.testtask4.presentation.ui.rss.RssModule
import zo.den.testtask4.presentation.ui.rss.RssScope

@Module
abstract class MainFragmentBuilder {

    @ContributesAndroidInjector(modules = [RssModule::class])
    @RssScope
    abstract fun buildOrderFragment(): RssFragment



}