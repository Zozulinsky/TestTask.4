package zo.den.testtask4.data.dao

import io.reactivex.Observable
import okhttp3.HttpUrl
import zo.den.testtask4.data.entity.ChannelItemEntity

interface ContentDao {

    fun getRss(httpUrl: HttpUrl): Observable<ChannelItemEntity>
}