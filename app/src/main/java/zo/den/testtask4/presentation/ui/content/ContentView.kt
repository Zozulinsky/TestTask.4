package zo.den.testtask4.presentation.ui.content

import android.content.Intent
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask4.data.entity.ChannelItemEntity
import zo.den.testtask4.presentation.base.BaseView

interface ContentView: BaseView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showContentList(list: MutableList<ChannelItemEntity>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProgress()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun hideProgress()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showNoConnection()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun openBrowser(intent: Intent)
}