package zo.den.testtask4.presentation.ui.content

import android.support.v4.app.Fragment
import okhttp3.HttpUrl
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ContentScreen(var urlRss: HttpUrl) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return ContentFragment.getInstance(urlRss)
    }

    override fun getScreenKey(): String {
        return ContentFragment::class.java.name
    }
}