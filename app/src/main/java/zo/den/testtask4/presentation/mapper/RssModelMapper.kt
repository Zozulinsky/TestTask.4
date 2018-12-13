package zo.den.testtask4.presentation.mapper

import io.reactivex.functions.Function
import zo.den.testtask4.data.network.pojo.Channel
import zo.den.testtask4.data.network.pojo.Item
import zo.den.testtask4.data.network.pojo.Link
import zo.den.testtask4.data.network.pojo.Rss
import zo.den.testtask4.presentation.model.RssModel

class RssModelMapper : Function<Rss, RssModel> {

    override fun apply(t: Rss): RssModel? {
        val channel: Channel? = t.channel
        //TODO исправить !!
        val messages: List<Item> = channel?.item!!
        return RssModel(messages)
    }
}