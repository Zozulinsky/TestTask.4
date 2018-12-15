package zo.den.testtask4.presentation.ui.content

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.rv_messages.*
import zo.den.testtask4.R
import zo.den.testtask4.data.entity.ChannelItemEntity
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
                val nameRss = name
                putString(KEY_NAME_RSS, name)
                val linkRss = link
                putString(KEY_LINK_RSS, link)
            }
        }
    }

    fun getNameRss(): String {
        //TODO исправить
        val nameRss = this.arguments?.getString(KEY_NAME_RSS)!!
        return nameRss
    }

    fun getLinkRss(): String {
        //TODO исправить
        val linkRss = this.arguments?.getString(KEY_LINK_RSS)!!
        return linkRss
    }

    override val layout: Int = R.layout.rv_messages

    @field:Inject
    lateinit var presenterProvider: Provider<ContentPresenter>

    @ProvidePresenter
    fun providePresenter(): ContentPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: ContentPresenter

    @field:Inject
    @field:ContentQualifier
    lateinit var contentAdapter: ContentAdapter

    @field:Inject
    @field:ContentQualifier
    lateinit var name: String

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        val context: Context? = this.context
        titleContent.text = name
        content_list.adapter = contentAdapter
        content_list.layoutManager = LinearLayoutManager(context)
        contentAdapter.listener = object : ContentAdapter.OnItemClickListener{
            override fun onItemClick(channelItemEntity: ChannelItemEntity) {
                presenter.onContent(channelItemEntity)
            }
        }
    }

    override fun showContentList(list: List<ChannelItemEntity>) {
        contentAdapter.list = list

    }
}