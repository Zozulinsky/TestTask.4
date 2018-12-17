package zo.den.testtask4.presentation.ui.content

import dagger.Module
import dagger.Provides
import zo.den.testtask4.presentation.adapter.ContentAdapter

@Module
class ContentModule {
    @Provides
    @ContentQualifier
    fun provideContentAdapter(): ContentAdapter = ContentAdapter()

    @Provides
    @ContentQualifier("linkRss")
    fun provideLinkRss(contentFragment: ContentFragment): String = contentFragment.getLinkRss()
}
