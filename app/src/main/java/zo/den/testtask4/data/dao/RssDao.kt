package zo.den.testtask4.data.dao

import io.reactivex.Observable
import zo.den.testtask4.data.network.pojo.Rss
import java.util.*

interface RssDao {
    fun getRss() : Observable<Rss>
}