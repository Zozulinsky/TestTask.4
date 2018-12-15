package zo.den.testtask4.data.entity


import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class RssEntity  constructor(){

    @set:Attribute(name = "version", required = false)
    @get:Attribute(name = "version", required = false)
    var version: String? = null

    @set:Element(name = "channel", required = false)
    @get:Element(name = "channel", required = false)
    var channel: ChannelEntity? = null

    override fun toString(): String {
        return "RSS{" +
                "version='" + version + '\''.toString() +
                ", channel=" + channel +
                '}'.toString()
    }
}