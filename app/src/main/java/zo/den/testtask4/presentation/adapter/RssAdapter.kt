package zo.den.testtask4.presentation.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.rss.view.*
import zo.den.testtask4.R
import zo.den.testtask4.data.entity.LinkDataEntity

class RssAdapter : RecyclerView.Adapter<RssAdapter.RssViewHolder>() {

    var listener: OnItemClickListener? = null

    var list: List<LinkDataEntity> = mutableListOf()
        set(value) {
            val result = DiffUtil.calculateDiff(RssDiffCallback(field, value))
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RssViewHolder {
        return RssViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.rss, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: RssViewHolder, p1: Int) {
        p0.bind(list[p1])
    }


    inner class RssViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardView: CardView? = null

        fun bind(linkDataEntity: LinkDataEntity) {
            cardView = itemView.cardviewRss
            itemView.nameofrss.text = linkDataEntity.name
            itemView.setOnClickListener(View.OnClickListener {
                listener?.onItemClick(linkDataEntity)
            })
            itemView.setOnLongClickListener(
                    {
                        listener?.onItemLongClick(linkDataEntity)
                        true
                    }
            )
        }
    }

    private class RssDiffCallback constructor(private val old: List<LinkDataEntity>, private val new: List<LinkDataEntity>)
        : DiffUtil.Callback() {
        override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
            return old[p0].id == new[p1].id
        }

        override fun getOldListSize(): Int {
            return old.size
        }

        override fun getNewListSize(): Int {
            return new.size
        }

        override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
            return old[p0].name == new[p1].name && old[p0].link == new[p1].link
        }
    }

    interface OnItemClickListener {
        fun onItemClick(linkDataEntity: LinkDataEntity)
        fun onItemLongClick(linkDataEntity: LinkDataEntity)
    }
}