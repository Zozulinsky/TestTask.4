package zo.den.testtask4.presentation

import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask4.presentation.ui.rss.RssScreen

object ScreenFactory {
    fun getRssScreen(): SupportAppScreen{
        return RssScreen()
    }


    //TODO добавить параметры, которые необходимо изменить
   /* fun getActionScreen(): SupportAppScreen{
        return ActionScreen()
    }

    fun getMessagesScreen(): SupportAppScreen{
        return ActionScreen()
    }*/
}