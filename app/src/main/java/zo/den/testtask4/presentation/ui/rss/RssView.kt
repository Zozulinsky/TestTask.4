package zo.den.testtask4.presentation.ui.rss

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask4.presentation.base.BaseView
import zo.den.testtask4.presentation.model.RssModel

interface RssView : BaseView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showRssList(list: List<RssModel>)
}