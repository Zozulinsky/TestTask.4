package zo.den.testtask4.data.network.pojo

import android.system.Os.link
import android.R.attr.description
import org.simpleframework.xml.*


@Root(strict = false)
class Channel {
    // Tricky part in Simple XML because the link is named twice
    @ElementList(entry = "link", inline = true, required = false)
    var links: String = ""

    @ElementList(name = "item", required = true, inline = true)
    var itemList: List<Item>? = null


    @Element
    internal var title: String = ""
    @Element
    internal var language: String? = null

    @Element(name = "ttl", required = false)
    internal var ttl: Int = 0

    @Element(name = "pubDate", required = false)
    internal var pubDate: String? = null

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


    @Root(name = "item", strict = false)
    class Item {

        @Element(name = "title", required = true)
        internal var title: String? = null//The title of the item.	Venice Film Festival Tries to Quit Sinking
        @Element(name = "link", required = true)
        internal var link: String? = null//The URL of the item.	http://www.nytimes.com/2002/09/07/movies/07FEST.html
        @Element(name = "description", required = true)
        internal var description: String? = null//The item synopsis.	Some of the most heated chatter at the Venice Film Festival this week was about the way that the arrival of the stars at the Palazzo del Cinema was being staged.
        @Element(name = "author", required = false)
        internal var author: String? = null//Email address of the author of the item. More.	oprah@oxygen.net
        @Element(name = "category", required = false)
        internal var category: String? = null//Includes the item in one or more categories. More.	Simpsons Characters
        @Element(name = "comments", required = false)
        internal var comments: String? = null//URL of a page for comments relating to the item. More.	http://www.myblog.org/cgi-local/mt/mt-comments.cgi?entry_id=290
        @Element(name = "enclosure", required = false)
        internal var enclosure: String? = null//	Describes a media object that is attached to the item. More.	<enclosure url="http://live.curry.com/mp3/celebritySCms.mp3" length="1069871" type="audio/mpeg"/>
        @Element(name = "guid", required = false)
        internal var guid: String? = null//A string that uniquely identifies the item. More.	<guid isPermaLink="true">http://inessential.com/2002/09/01.php#a2</guid>
        @Element(name = "pubDate", required = false)
        internal var pubDate: String? = null//	Indicates when the item was published. More.	Sun, 19 May 2002 15:21:36 GMT
        @Element(name = "source", required = false)
        internal var source: String? = null//	The RSS channel that the item came from. More.

        override fun toString(): String {
            return "Item{" +
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
}