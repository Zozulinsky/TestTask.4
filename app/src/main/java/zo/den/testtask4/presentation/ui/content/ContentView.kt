package zo.den.testtask4.presentation.ui.content

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask4.data.entity.ChannelItemEntity
import zo.den.testtask4.presentation.base.BaseView
import zo.den.testtask4.presentation.model.ContentModel

interface ContentView: BaseView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showContentList(list: List<ChannelItemEntity>)
}