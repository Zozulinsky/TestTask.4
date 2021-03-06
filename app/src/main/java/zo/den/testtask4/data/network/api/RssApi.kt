package zo.den.testtask4.data.network.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import zo.den.testtask4.data.entity.RssEntity
import zo.den.testtask4.data.network.service.RssService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RssApi @Inject constructor(private val okHttpClient: OkHttpClient){

    fun getRss(httpUrl: HttpUrl): Single<RssEntity> {
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

    fun checkRss(httpUrl: HttpUrl): Single<Response<ResponseBody>> {
        val rssService = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(httpUrl.scheme() + "://" + httpUrl.host() + "/")
                .validateEagerly(false)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
                .create(RssService::class.java)
        return rssService.checkRss(httpUrl.encodedPath())
    }
}