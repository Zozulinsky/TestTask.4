package zo.den.testtask4.data.dao

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.HttpUrl
import okhttp3.ResponseBody
import retrofit2.Response
import zo.den.testtask4.data.entity.ChannelItemEntity

interface ContentDao {
    fun checkRss(httpUrl: HttpUrl) : Single<Response<ResponseBody>>
    fun getRss(httpUrl: HttpUrl): Observable<ChannelItemEntity>
}