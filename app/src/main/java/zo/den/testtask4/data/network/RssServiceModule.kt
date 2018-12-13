package zo.den.testtask4.data.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import zo.den.testtask4.data.DataQuailifier
import zo.den.testtask4.data.network.Service.RssService
import zo.den.testtask4.presentation.ui.rss.RssLinkQualifier
import zo.den.testtask4.presentation.ui.rss.RssModule

@Module(includes = [RssModule::class])
class RssServiceModule {


    @Provides
    fun provideRssService(@RssLinkQualifier baseUrl: String, okHttpClient: OkHttpClient): RssService {

        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
                .create(RssService::class.java)

    }
}