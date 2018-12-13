package zo.den.testtask4.data.dao.impl

import io.reactivex.Observable
import zo.den.testtask4.data.dao.RssDao
import zo.den.testtask4.data.network.api.RssApi
import zo.den.testtask4.data.network.pojo.Link
import zo.den.testtask4.data.network.pojo.Rss
import javax.inject.Inject

class RssDaoImpl @Inject constructor() : RssDao {

    @Inject
    lateinit var rssApi: RssApi

    override fun getRss(): Observable<Rss> {
        return rssApi.getRss()
                .flatMapObservable {
                    Observable.just(it)
                }
    }
}