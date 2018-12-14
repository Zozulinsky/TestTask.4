package zo.den.testtask4.data.dao

import io.reactivex.Observable
import okhttp3.HttpUrl
import zo.den.testtask4.data.network.pojo.Item
import zo.den.testtask4.data.network.pojo.Rss

interface ContentDao {

    fun getRss(httpUrl: HttpUrl): Observable<Item>
}