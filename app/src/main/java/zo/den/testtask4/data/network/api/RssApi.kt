package zo.den.testtask4.data.network.api

import io.reactivex.Single
import zo.den.testtask4.data.network.Service.RssService
import zo.den.testtask4.data.network.pojo.Rss
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RssApi @Inject constructor(private val rssService: RssService){
    fun getRss(): Single<Rss> {
        return rssService.getRss()
    }
}