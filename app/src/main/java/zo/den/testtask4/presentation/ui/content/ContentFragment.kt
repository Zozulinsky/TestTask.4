package zo.den.testtask4.presentation.ui.content

import okhttp3.HttpUrl
import zo.den.testtask4.R
import zo.den.testtask4.presentation.base.MoxyFragment
import zo.den.testtask4.presentation.model.ContentModel
import zo.den.testtask4.presentation.ui.rss.RssFragment

class ContentFragment : MoxyFragment(), ContentView {

    companion object {
        fun getInstance(urlRss: HttpUrl): RssFragment = RssFragment()
    }

    override val layout: Int = R.layout.rv_messages

    override fun showContentList(contentModel: ContentModel) {

    }
}