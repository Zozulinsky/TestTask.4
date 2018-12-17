package zo.den.testtask4.data.dao.impl

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.HttpUrl
import okhttp3.ResponseBody
import retrofit2.Response
import zo.den.testtask4.data.dao.ContentDao
import zo.den.testtask4.data.entity.ChannelItemEntity
import zo.den.testtask4.data.network.api.RssApi
import javax.inject.Inject

class ContentDaoImpl @Inject constructor() : ContentDao {
    @Inject
    lateinit var rssApi: RssApi

    override fun getRss(httpUrl: HttpUrl): Observable<ChannelItemEntity> {
        return rssApi.getRss(httpUrl)
                .flatMapObservable {
                    it.channel.let { channel ->
                        if (channel != null)
                            Observable.fromIterable(channel.itemList)
                        else {
                            throw Exception()
                        }
                    }
                }
    }

    override fun checkRss(httpUrl: HttpUrl): Single<Response<ResponseBody>> {
        return rssApi.checkRss(httpUrl)

    }
}