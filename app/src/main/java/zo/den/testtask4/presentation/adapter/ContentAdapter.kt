package zo.den.testtask4.presentation.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.messages.view.*
import kotlinx.android.synthetic.main.rss.view.*
import zo.den.testtask4.R
import zo.den.testtask4.data.entity.ChannelItemEntity
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.model.ContentModel

class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    var listener: ContentAdapter.OnItemClickListener? = null

    var list: List<ChannelItemEntity> = emptyList<ChannelItemEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContentAdapter.ContentViewHolder {
        return ContentViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.rss, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ContentAdapter.ContentViewHolder, p1: Int) {
        p0.bind(list[p1])
    }


    inner class ContentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardView: CardView? = null

        fun bind(channelItemEntity: ChannelItemEntity) {
            cardView = itemView.cardviewRss
            itemView.title_message.text = channelItemEntity.title
            itemView.date.text = channelItemEntity.pubDate
            itemView.content.text = channelItemEntity.description
            itemView.setOnClickListener({
                listener?.onItemClick(channelItemEntity)
            })

        }
    }

    interface OnItemClickListener {
        fun onItemClick(channelItemEntity: ChannelItemEntity)
    }
}