package zo.den.testtask4.presentation.ui.rss

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.base.BaseView

interface RssView : BaseView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showRssList(list: List<LinkDataEntity>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showAddDialog()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showActionDialog(linkDataEntity: LinkDataEntity)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showEditDialog(linkDataEntity: LinkDataEntity)
}