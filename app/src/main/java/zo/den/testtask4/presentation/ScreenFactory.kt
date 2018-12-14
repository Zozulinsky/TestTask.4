package zo.den.testtask4.presentation

import okhttp3.HttpUrl
import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask4.presentation.ui.content.ContentScreen
import zo.den.testtask4.presentation.ui.rss.RssScreen

object ScreenFactory {
    fun getRssScreen(): SupportAppScreen{
        return RssScreen()
    }

    fun getContentScreen(url : String): SupportAppScreen{
        return ContentScreen(HttpUrl.parse(url)!!)
    }


    //TODO добавить параметры, которые необходимо изменить
   /* fun getActionScreen(): SupportAppScreen{
        return ActionScreen()
    }

    fun getMessagesScreen(): SupportAppScreen{
        return ActionScreen()
    }*/
}