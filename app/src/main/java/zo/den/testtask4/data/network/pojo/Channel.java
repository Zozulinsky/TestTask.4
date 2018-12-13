package zo.den.testtask4.data.network.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
@Root(name = "channel")
public class Channel {
    @Element
    private String title;
    @Element
    private String description;
    @Element
    private String link;

    @ElementList(entry = "item", inline = true)
    private ArrayList<Item> item;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public ArrayList<Item> getItem ()
    {
        return item;
    }

    public void setItem (ArrayList<Item>item)
    {
        this.item = item;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", description = "+description+", link = "+link+", item = "+item+"]";
    }
}
