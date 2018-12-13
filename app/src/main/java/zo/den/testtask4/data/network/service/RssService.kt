package zo.den.testtask4.data.network.service

import io.reactivex.Single
import retrofit2.http.GET
import zo.den.testtask4.data.network.pojo.Rss

interface RssService {
    @GET("/")
    fun getRss(): Single<Rss>
}