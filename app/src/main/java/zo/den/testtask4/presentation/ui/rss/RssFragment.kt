package zo.den.testtask4.presentation.ui.rss

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.rv_rss.*
import zo.den.testtask4.R
import zo.den.testtask4.presentation.adapter.RssAdapter
import zo.den.testtask4.presentation.base.MoxyFragment
import zo.den.testtask4.presentation.model.RssModel
import javax.inject.Inject
import javax.inject.Provider

class RssFragment : MoxyFragment(), RssView{

    companion object {
        fun getInstance(): RssFragment = RssFragment()
    }

    override val layout: Int = R.layout.rv_rss

    @field:Inject
    lateinit var presenterProvider: Provider<RssPresenter>

    @ProvidePresenter
    fun providePresenter(): RssPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: RssPresenter

    @field:Inject
    @field:RssQualifier
    lateinit var rssAdapter: RssAdapter

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        val context: Context? = this.context
        rss_list.adapter = rssAdapter
        rss_list.layoutManager = LinearLayoutManager(context)
        rssAdapter.listener = object : RssAdapter.OnItemClickListener{
            override fun onItemClick(rssModel: RssModel) {
                //presenter.onRss(rssModel)
            }
        }
    }

    override fun showRssList(sharedPreferences: SharedPreferences) {
        rssAdapter.map = sharedPreferences.all
    }
}