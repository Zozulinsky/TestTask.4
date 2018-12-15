package zo.den.testtask4.presentation.mapper

import io.reactivex.functions.Function
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.model.RssModel

class RssModelMapper() : Function<LinkDataEntity, RssModel> {

    override fun apply(t: LinkDataEntity): RssModel? {

        return t.id?.let { RssModel(it, t.name, t.link) }
    }
}