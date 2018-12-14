package zo.den.testtask4.data.network.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import zo.den.testtask4.data.network.pojo.Rss
import zo.den.testtask4.data.network.service.RssService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RssApi @Inject constructor(okHttpClient: OkHttpClient){

    private val okHttpClient: OkHttpClient = okHttpClient

    fun getRss(httpUrl: HttpUrl): Single<Rss> {
        val rssService = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(httpUrl.scheme() + "://" + httpUrl.host() + "/")
                .validateEagerly(false)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
                .create(RssService::class.java)
        return rssService.getRss(httpUrl.encodedPath())
    }
}