package zo.den.testtask4.data.network.pojo


import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
class Channel {
    @set:ElementList(entry = "link", inline = true, required = false)
    @get:ElementList(entry = "link", inline = true, required = false)
    var links: List<Link>? = null

    @set:ElementList(name = "item", required = true, inline = true)
    @get:ElementList(name = "item", required = true, inline = true)
    var itemList: List<Item>? = null


    @set:Element(name = "title", required = false)
    @get:Element(name = "title", required = false)
    var title: String? = null
    @set:Element(name = "language", required = false)
    @get:Element(name = "language", required = false)
    var language: String? = null

    @set:Element(name = "ttl", required = false)
    @get:Element(name = "ttl", required = false)
    var ttl: Int = 0

    @set:Element(name = "pubDate", required = false)
    @get:Element(name = "pubDate", required = false)
    var pubDate: String? = null

    override fun toString(): String {
        return "Channel{" +
                "links=" + links +
                ", itemList=" + itemList +
                ", title='" + title + '\''.toString() +
                ", language='" + language + '\''.toString() +
                ", ttl=" + ttl +
                ", pubDate='" + pubDate + '\''.toString() +
                '}'.toString()
    }
}
