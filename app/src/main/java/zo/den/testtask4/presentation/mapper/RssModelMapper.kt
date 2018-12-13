package zo.den.testtask4.presentation.mapper

import io.reactivex.functions.Function
import zo.den.testtask4.data.network.pojo.Channel
import zo.den.testtask4.data.network.pojo.Rss
import zo.den.testtask4.presentation.model.RssModel

class RssModelMapper : Function<Rss, RssModel> {

    override fun apply(t: Rss): RssModel? {
        val channel: Channel? = t.channel
        //TODO исправить !!
        val title_rss = channel!!.title
        val link_rss = channel!!.links
        val messages: List<Channel.Item> = channel!!.itemList!!

        return RssModel(title_rss , link_rss, messages)
    }
}