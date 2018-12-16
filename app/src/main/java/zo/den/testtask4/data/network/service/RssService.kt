package zo.den.testtask4.data.network.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url
import zo.den.testtask4.data.entity.RssEntity

interface RssService {
    @GET
    fun getRss(@Url url: String): Single<RssEntity>
}