package zo.den.testtask4.presentation.mapper

import android.content.SharedPreferences
import io.reactivex.functions.Function
import zo.den.testtask4.presentation.model.RssModel

class RssModelMapper(sharedPreferences: SharedPreferences) : Function<SharedPreferences, RssModel> {

    override fun apply(t: SharedPreferences): RssModel? {

        return RssModel(t.all)
    }
}