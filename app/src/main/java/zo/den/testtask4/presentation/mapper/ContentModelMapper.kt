package zo.den.testtask4.presentation.mapper

import io.reactivex.functions.Function
import zo.den.testtask4.data.network.pojo.Item
import zo.den.testtask4.presentation.model.ContentModel

class ContentModelMapper: Function<Item, ContentModel>{
    override fun apply(t: Item): ContentModel {
        val title = t.title.throwIfNull()
        val date = t.pubDate.throwIfNull()
        val content = t.description.throwIfNull()
        val link = t.guid.throwIfNull()
        return ContentModel(title, date, content, link)
    }
}