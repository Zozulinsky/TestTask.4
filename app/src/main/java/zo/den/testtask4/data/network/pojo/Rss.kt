package zo.den.testtask4.data.network.pojo

import org.simpleframework.xml.*

@Root
class Rss {

    @Attribute
    internal var version: String? = null

    @Element
    var channel: Channel? = null
        internal set

    override fun toString(): String {
        return "RSS{" +
                "version='" + version + '\''.toString() +
                ", channel=" + channel +
                '}'.toString()
    }
}