package zo.den.testtask4.data.network.pojo


import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "link", strict = false)
class Link {
    @set:Attribute(required = false)
    @get:Attribute(required = false)
    var href: String? = null

    @set:Attribute(required = false)
    @get:Attribute(required = false)
    var rel: String? = null

    @set:Attribute(name = "type", required = false)
    @get:Attribute(name = "type", required = false)
    var contentType: String? = null

    @set:Text(required = false)
    @get:Text(required = false)
    var link: String? = null
}
