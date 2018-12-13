package zo.den.testtask4.presentation.mapper

import io.reactivex.functions.Function
import zo.den.testtask4.data.network.pojo.Channel
import zo.den.testtask4.data.network.pojo.Item
import zo.den.testtask4.data.network.pojo.Rss
import zo.den.testtask4.presentation.model.RssModel

class RssModelMapper : Function<Rss, RssModel> {

    override fun apply(t: Rss): RssModel? {
        val channel = t.channel
        var title_rss= ""
        var link_rss = ""
        var messages: ArrayList<Item> = arrayListOf()

        if (channel != null) {
            title_rss = channel.title
            link_rss = channel.link
            messages = channel.item
        }

        return RssModel(title_rss , link_rss, messages)
    }
}