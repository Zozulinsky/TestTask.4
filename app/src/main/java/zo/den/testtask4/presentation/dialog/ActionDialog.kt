package zo.den.testtask4.presentation.dialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.dialog_action.*
import zo.den.testtask4.R
import zo.den.testtask4.data.entity.LinkDataEntity

class ActionDialog : DialogFragment() {

    companion object {
        private const val KEY_RSS: String = "rss"
        fun getInstance(linkDataEntity: LinkDataEntity): ActionDialog = ActionDialog().also {
            it.arguments = Bundle().apply {
                putParcelable(KEY_RSS, linkDataEntity)
            }
        }
    }

    var listener: OnActionListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: LinkDataEntity? = this.arguments?.getParcelable(KEY_RSS)
        edit_rss.setOnClickListener {
            if (data != null)
                listener?.onEditRss(data)
            this.dismiss()
        }
        remove_rss.setOnClickListener {
            if (data != null)
                listener?.onRemoveRss(data)
            this.dismiss()
        }

        cancel_action.setOnClickListener {
            this.dismiss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_action, container, false)
    }

    interface OnActionListener {
        fun onEditRss(linkDataEntity: LinkDataEntity)
        fun onRemoveRss(linkDataEntity: LinkDataEntity)
    }
}