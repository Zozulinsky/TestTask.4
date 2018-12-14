package zo.den.testtask4.data.dao.impl

import io.reactivex.Observable
import okhttp3.HttpUrl
import zo.den.testtask4.data.dao.ContentDao
import zo.den.testtask4.data.network.api.RssApi
import zo.den.testtask4.data.network.pojo.Item
import zo.den.testtask4.data.network.pojo.Rss
import javax.inject.Inject

class ContentDaoImpl @Inject constructor() : ContentDao{
    @Inject
    lateinit var rssApi: RssApi

    override fun getRss(httpUrl: HttpUrl): Observable<Item> {
        return rssApi.getRss(httpUrl)
                .flatMapObservable {
                    Observable.fromIterable(it.channel.itemList)
                }
    }
}