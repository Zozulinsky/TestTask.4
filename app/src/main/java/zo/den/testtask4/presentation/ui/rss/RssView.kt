package zo.den.testtask4.presentation.ui.rss

import android.content.SharedPreferences
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.base.BaseView
import zo.den.testtask4.presentation.model.RssModel

interface RssView : BaseView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showRssList(list: List<LinkDataEntity>)
}