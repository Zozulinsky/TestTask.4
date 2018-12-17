package zo.den.testtask4.presentation.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.dialog_edit.*
import zo.den.testtask4.R
import zo.den.testtask4.data.entity.LinkDataEntity

class EditDialog : DialogFragment() {

    companion object {
        private const val KEY_EDIT = "edit"
        fun getInstance(linkDataEntity: LinkDataEntity): EditDialog = EditDialog().also {
            it.arguments = Bundle().apply {
                putParcelable(KEY_EDIT, linkDataEntity)
            }
        }
    }

    var listener: OnEditListener? = null

    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: LinkDataEntity? = arguments?.getParcelable(KEY_EDIT)
        if (data != null) {
            edit_name_rss.setText(data.name)
            edit_url_rss.setText(data.link)
            edit_url_rss.setSelection(edit_url_rss.text.length)
        }
        btn_edit.setOnClickListener {
            val nameRss = edit_name_rss.text.toString()
            val urlRss = edit_url_rss.text.toString()
            if (data != null && Patterns.WEB_URL.matcher(urlRss).matches() && nameRss.length > 0) {
                listener?.onEditRss(LinkDataEntity(data.id, nameRss, urlRss))
                text_checkEditRss.visibility = TextView.INVISIBLE
                this.dismiss()
            } else {
                text_checkEditRss.visibility = TextView.VISIBLE
            }
        }
        btn_cancel.setOnClickListener {
            this.dismiss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_edit, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setTitle(R.string.add_rss)
        return dialog
    }

    interface OnEditListener {
        fun onEditRss(linkDataEntity: LinkDataEntity)
    }
}
