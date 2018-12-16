package zo.den.testtask4.presentation.ui.content

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_content.*
import zo.den.testtask4.R
import zo.den.testtask4.data.entity.ChannelItemEntity
import zo.den.testtask4.exceptions.throwIfNull
import zo.den.testtask4.presentation.adapter.ContentAdapter
import zo.den.testtask4.presentation.base.MoxyFragment
import javax.inject.Inject
import javax.inject.Provider

class ContentFragment : MoxyFragment(), ContentView {

    companion object {
        private const val KEY_NAME_RSS: String = "name_rss"
        private const val KEY_LINK_RSS: String = "link_rss"
        fun getInstance(name: String, link: String): ContentFragment = ContentFragment().also {
            it.arguments = Bundle().apply {
                putString(KEY_NAME_RSS, name)
                putString(KEY_LINK_RSS, link)
            }
        }
    }

    fun getLinkRss(): String {
        var linkRss = ""
        linkRss = arguments?.getString(KEY_LINK_RSS).throwIfNull()
        return linkRss
    }

    override val layout: Int = R.layout.fragment_content

    @field:Inject
    lateinit var presenterProvider: Provider<ContentPresenter>

    @ProvidePresenter
    fun providePresenter(): ContentPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: ContentPresenter

    @field:Inject
    @field:ContentQualifier
    lateinit var contentAdapter: ContentAdapter

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        setSupportTitle(arguments?.getString(KEY_NAME_RSS)!!)
        val context = this.context
        content_list.adapter = contentAdapter
        content_list.layoutManager = LinearLayoutManager(context)
        refresh.setOnRefreshListener {
            presenter.onUpdate()
        }
        contentAdapter.listener = object : ContentAdapter.OnItemClickListener {
            override fun onItemClick(channelItemEntity: ChannelItemEntity) {
                presenter.onContent(channelItemEntity)
            }
        }
    }

    override fun showContentList(list: MutableList<ChannelItemEntity>) {
        contentAdapter.list = list
    }

    override fun showProgress() {
        refresh.isRefreshing = true
    }

    override fun hideProgress() {
        refresh.isRefreshing = false
    }

    override fun showNoConnection() {
        no_connection.visibility = EditText.VISIBLE
    }

    override fun openBrowser(intent: Intent) {
        startActivity(intent)
    }
}