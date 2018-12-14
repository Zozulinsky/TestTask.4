package zo.den.testtask4.data.network.service

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface RssService {
    @GET
    fun getRss(@Url url: String): Single<Rss>

    @GET("/")
    fun getRssBody(): Call<ResponseBody>
}