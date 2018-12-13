package zo.den.testtask4.data.network.api

import io.reactivex.Single
import zo.den.testtask4.data.network.pojo.Link
import zo.den.testtask4.data.network.pojo.Rss
import zo.den.testtask4.data.network.service.RssService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RssApi @Inject constructor(private val rssService: RssService){
    fun getRss(): Single<Rss> {
        return rssService.getRss()
    }
}