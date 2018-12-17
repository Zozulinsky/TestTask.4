package zo.den.testtask4.data.network.service

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url
import zo.den.testtask4.data.entity.RssEntity

interface RssService {
    @GET
    fun getRss(@Url url: String): Single<RssEntity>

    @GET
    fun checkRss(@Url url: String): Single<Response<ResponseBody>>
}