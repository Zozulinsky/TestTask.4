package zo.den.testtask4.presentation.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.messages.view.*
import zo.den.testtask4.R
import zo.den.testtask4.presentation.model.ContentModel

class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    var listener: OnItemClickListener? = null

    var list: MutableList<ContentModel> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContentViewHolder {
        return ContentViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.rss, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ContentViewHolder, p1: Int) {
        p0.bind(list[p1])
    }


    inner class ContentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardView: CardView? = null

        fun bind(contentModel: ContentModel) {
            cardView = itemView.cardview

            itemView.setOnClickListener(View.OnClickListener {
                listener?.onItemClick(contentModel)
            })
        }
    }

    interface OnItemClickListener {
        fun onItemClick(contentModel: ContentModel)
    }
}