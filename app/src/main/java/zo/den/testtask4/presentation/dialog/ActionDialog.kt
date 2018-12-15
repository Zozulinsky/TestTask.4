package zo.den.testtask4.presentation.dialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import zo.den.testtask4.R
import zo.den.testtask4.presentation.base.MoxyDialogFragment

class ActionDialog : DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        val actionDialog = inflater.inflate(R.layout.action_dialog, container, false)

        val editRss: Button = actionDialog.findViewById(R.id.edit_rss)
        val removeRss: Button = actionDialog.findViewById(R.id.remove_rss)
        val cancel: Button = actionDialog.findViewById(R.id.cancel_action)

        editRss.setOnClickListener({
            //TODO добавить логику вызова диалога редактирования RSS
            this.dismiss()
        })
        removeRss.setOnClickListener({
            //TODO добавить логику удаления RSS
            this.dismiss()
        })

        cancel.setOnClickListener({
            this.dismiss()
        })
    }
}