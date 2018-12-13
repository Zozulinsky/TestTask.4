package zo.den.testtask4.data.dao

import io.reactivex.Observable
import zo.den.testtask4.data.network.pojo.Rss

interface RssDao {
    fun getRss() : Observable<Rss>
}