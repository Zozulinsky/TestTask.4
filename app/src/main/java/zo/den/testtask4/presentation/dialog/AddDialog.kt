package zo.den.testtask4.presentation.dialog

import android.content.DialogInterface
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import zo.den.testtask4.R
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import zo.den.testtask4.data.database.LinkDB
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.adapter.RssAdapter
import zo.den.testtask4.presentation.ui.rss.RssFragment
import zo.den.testtask4.presentation.ui.rss.RssQualifier
import javax.inject.Inject


class AddDialog : DialogFragment() {

    var listener: OnAddListener? = null

    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.setTitle(getString(R.string.title_addDialog))
        val addDialog = inflater.inflate(R.layout.dialog_add, container, false)

        val addRss: Button = addDialog.findViewById(R.id.btn_add)
        val inputRss: EditText = addDialog.findViewById(R.id.input_url_rss)
        val inputNameRss: EditText = addDialog.findViewById(R.id.input_name_rss)
        addRss.setOnClickListener({
            val rss: String = inputRss.text.toString()
            val name: String = inputNameRss.text.toString()
            val linkDataEntity: LinkDataEntity? = LinkDataEntity(null, rss, name)
            val linkDB: LinkDB = LinkDB()
            if (linkDataEntity != null) {
                linkDB.insertLink(linkDataEntity)
            }
            this.dismiss()
        })
        val cancel: Button = addDialog.findViewById(R.id.btn_cancel)
        cancel.setOnClickListener({
            this.dismiss()
        })
        return addDialog
    }

    override fun onDismiss(dialog: DialogInterface?) {
        //TODO добавить обновление линков на первом фрагменте после закрытия диалога
        super.onDismiss(dialog)
    }

    interface OnAddListener {
        fun onAddRss()
    }
}
