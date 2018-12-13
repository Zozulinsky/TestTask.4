package zo.den.testtask4.presentation.ui.rss

import dagger.Module
import dagger.Provides
import zo.den.testtask4.presentation.adapter.RssAdapter

@Module
class RssModule {
    @Provides
    @RssQualifier
    fun provideRssAdapter(): RssAdapter = RssAdapter()

    @Provides
    @RssLinkQualifier
    fun provideRssLink(): String = RssPresenter().linkRss
}
