package zo.den.testtask4.presentation.dialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import zo.den.testtask4.R
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.ui.content.ContentFragment
import javax.inject.Inject

class ActionDialog : DialogFragment(){

    companion object {
        private const val KEY_RSS: String = "rss"
        fun getInstance(linkDataEntity: LinkDataEntity): ActionDialog = ActionDialog().also {
            it.arguments = Bundle().apply {
                putParcelable(KEY_RSS, linkDataEntity)
            }
        }
    }

    fun getDataEntity(): LinkDataEntity{
        val linkDataEntity: LinkDataEntity = this.arguments?.getParcelable(KEY_RSS)!!
        return linkDataEntity
    }

    @field:Inject
    @LinkQualifier
    lateinit var linkDataEntity: LinkDataEntity

    var listener: OnActionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        val actionDialog = inflater.inflate(R.layout.action_dialog, container, false)
        val editRss: Button = actionDialog.findViewById(R.id.edit_rss)
        val removeRss: Button = actionDialog.findViewById(R.id.remove_rss)
        val cancel: Button = actionDialog.findViewById(R.id.cancel_action)

        editRss.setOnClickListener({
            listener?.editRss()
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

    interface OnActionListener{
        fun editRss()
        fun removeRss()
    }
}