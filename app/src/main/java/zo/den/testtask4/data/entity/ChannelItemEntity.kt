package zo.den.testtask4.data.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
class ChannelItemEntity {

    @set:Element(name = "title", required = true)
    @get:Element(name = "title", required = true)
    var title: String = ""
    @set:Element(name = "link", required = true)
    @get:Element(name = "link", required = true)
    var link: String? = null//The URL of the item.	http://www.nytimes.com/2002/09/07/movies/07FEST.html
    @set:Element(name = "description", required = true)
    @get:Element(name = "description", required = true)
    var description: String? = null//The item synopsis.	Some of the most heated chatter at the Venice Film Festival this week was about the way that the arrival of the stars at the Palazzo del Cinema was being staged.
    @set:Element(name = "author", required = false)
    @get:Element(name = "author", required = false)
    var author: String? = null//Email address of the author of the item. More.	oprah@set:oxygen.net
    @set:Element(name = "category", required = false)
    @get:Element(name = "category", required = false)
    var category: String? = null//Includes the item in one or more categories. More.	Simpsons Characters
    @set:Element(name = "comments", required = false)
    @get:Element(name = "comments", required = false)
    var comments: String? = null//URL of a page for comments relating to the item. More.	http://www.myblog.org/cgi-local/mt/mt-comments.cgi?entry_id=290
    @set:Element(name = "enclosure", required = false)
    @get:Element(name = "enclosure", required = false)
    var enclosure: String? = null//	Describes a media object that is attached to the item. More.	<enclosure url="http://live.curry.com/mp3/celebritySCms.mp3" length="1069871" type="audio/mpeg"/>
    @set:Element(name = "guid", required = false)
    @get:Element(name = "guid", required = false)
    var guid: String? = null//A string that uniquely identifies the item. More.	<guid isPermaLink="true">http://inessential.com/2002/09/01.php#a2</guid>
    @set:Element(name = "pubDate", required = false)
    @get:Element(name = "pubDate", required = false)
    var pubDate: String? = null//	Indicates when the item was published. More.	Sun, 19 May 2002 15:21:36 GMT
    @set:Element(name = "source", required = false)
    @get:Element(name = "source", required = false)
    var source: String? = null//	The RSS channel that the item came from. More.

    override fun toString(): String {
        return "ChannelItemEntity{" +
                "title='" + title + '\''.toString() +
                ", link='" + link + '\''.toString() +
                ", description='" + description + '\''.toString() +
                ", author='" + author + '\''.toString() +
                ", category='" + category + '\''.toString() +
                ", comments='" + comments + '\''.toString() +
                ", enclosure='" + enclosure + '\''.toString() +
                ", guid='" + guid + '\''.toString() +
                ", pubDate='" + pubDate + '\''.toString() +
                ", source='" + source + '\''.toString() +
                '}'.toString()
    }
}