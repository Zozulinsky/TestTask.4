package zo.den.testtask4.presentation.ui.rss

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen


class RssScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return RssFragment.getInstance()
    }

    override fun getScreenKey(): String {
        return RssFragment::class.java.name
    }
}