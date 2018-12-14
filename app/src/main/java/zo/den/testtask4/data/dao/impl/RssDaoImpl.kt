package zo.den.testtask4.data.dao.impl

import android.app.Application
import zo.den.testtask4.data.dao.RssDao
import javax.inject.Inject
import android.app.Activity



class RssDaoImpl @Inject constructor(application: Application): RssDao {

    val context = application.applicationContext

    fun addFavoriteItem(activity: Activity, favoriteItem: String): Boolean {
        //Get previous favorite items
        var favoriteList: String? = getStringFromPreferences(activity, null, "favorites")
        // Append new Favorite item
        if (favoriteList != null) {
            favoriteList = "$favoriteList,$favoriteItem"
        } else {
            favoriteList = favoriteItem
        }
        // Save in Shared Preferences
        return putStringInPreferences(activity, favoriteList, "favorites")
    }

    fun getFavoriteList(activity: Activity): Array<String> {
        val favoriteList = getStringFromPreferences(activity, null, "favorites")
        return convertStringToArray(favoriteList)
    }

    private fun putStringInPreferences(activity: Activity, nick: String, key: String): Boolean {
        val sharedPreferences = activity.getPreferences(Activity.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, nick)
        editor.commit()
        return true
    }

    private fun getStringFromPreferences(activity: Activity, defaultValue: String?, key: String): String {
        val sharedPreferences = activity.getPreferences(Activity.MODE_PRIVATE)
        return sharedPreferences.getString(key, defaultValue)
    }

    private fun convertStringToArray(str: String): Array<String> {
        return str.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }
}