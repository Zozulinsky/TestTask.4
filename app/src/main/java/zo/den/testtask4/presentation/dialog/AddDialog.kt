package zo.den.testtask4.presentation.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.dialog_add.*
import zo.den.testtask4.R

class AddDialog : DialogFragment() {

    companion object {
        fun getInstance(): AddDialog = AddDialog()
    }

    var listener: OnAddListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        input_name_rss.setSelection(input_name_rss.text.length)
        input_url_rss.setSelection(input_url_rss.text.length)
        btn_add.setOnClickListener {
            val nameRss = input_name_rss.text.toString()
            val urlRss = input_url_rss.text.toString()
            if (Patterns.WEB_URL.matcher(urlRss).matches() && nameRss.length > 0) {
                listener?.onAddRss(nameRss, urlRss)
                text_checkRss.visibility = TextView.INVISIBLE
                this.dismiss()
            }else{
                text_checkRss.visibility = TextView.VISIBLE
            }
        }
        btn_cancel.setOnClickListener {
            this.dismiss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_add, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setTitle(R.string.add_rss)
        return dialog
    }

    interface OnAddListener {
        fun onAddRss(name: String, link: String)
    }
}
