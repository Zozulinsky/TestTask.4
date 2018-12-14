package zo.den.testtask4.data.dao

import android.content.SharedPreferences
import io.reactivex.Observable
import okhttp3.HttpUrl
import zo.den.testtask4.data.network.pojo.Rss

interface RssDao {
    fun getRss() : SharedPreferences

    fun saveRss(rssMap: HashMap<String, String>) : SharedPreferences

    fun removeRss()

}