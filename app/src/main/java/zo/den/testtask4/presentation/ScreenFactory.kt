package zo.den.testtask4.presentation

import okhttp3.HttpUrl
import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask4.presentation.ui.content.ContentScreen
import zo.den.testtask4.presentation.ui.rss.RssScreen

object ScreenFactory {
    fun getRssScreen(): SupportAppScreen{
        return RssScreen()
    }

    fun getContentScreen(name: String, link: String): SupportAppScreen{
        return ContentScreen(name, link)
    }
}