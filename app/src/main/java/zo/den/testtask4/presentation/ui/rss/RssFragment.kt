package zo.den.testtask4.presentation.ui.rss

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_rss.*
import zo.den.testtask4.R
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.adapter.RssAdapter
import zo.den.testtask4.presentation.base.MoxyFragment
import zo.den.testtask4.presentation.dialog.ActionDialog
import zo.den.testtask4.presentation.dialog.AddDialog
import zo.den.testtask4.presentation.dialog.EditDialog
import javax.inject.Inject
import javax.inject.Provider

class RssFragment : MoxyFragment(), RssView {

    companion object {
        private const val TAG_ADD_DIALOG = "add_rss"
        private const val TAG_ACTION_DIALOG = "dialog_action"
        private const val TAG_EDIT_DIALOG = "edit_dialog"
        fun getInstance(): RssFragment = RssFragment()
    }

    override val layout: Int = R.layout.fragment_rss

    @field:Inject
    lateinit var presenterProvider: Provider<RssPresenter>

    @ProvidePresenter
    fun providePresenter(): RssPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: RssPresenter

    @field:Inject
    @field:RssQualifier
    lateinit var rssAdapter: RssAdapter

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        setSupportTitle(getString(R.string.title_RssFragment))
        val context: Context? = this.context
        rss_list.adapter = rssAdapter
        rss_list.layoutManager = LinearLayoutManager(context)
        rssAdapter.listener = object : RssAdapter.OnItemClickListener {
            override fun onItemClick(linkDataEntity: LinkDataEntity) {
                presenter.onRss(linkDataEntity)
            }

            override fun onItemLongClick(linkDataEntity: LinkDataEntity) {
                presenter.onRssLong(linkDataEntity)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_rss, container, false);
        val fab = view.findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            presenter.onShowAddDialog()
        }
        return view
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        if (childFragment is AddDialog && childFragment.tag == TAG_ADD_DIALOG) {
            childFragment.listener = object : AddDialog.OnAddListener {
                override fun onAddRss(name: String, link: String) {
                    presenter.onAddRss(name, link)
                }
            }
        }
        if (childFragment is ActionDialog && childFragment.tag == TAG_ACTION_DIALOG ) {
            childFragment.listener = object : ActionDialog.OnActionListener {
                override fun onEditRss(linkDataEntity: LinkDataEntity) {
                    presenter.onOpenEditLinkDialog(linkDataEntity)
                }

                override fun onRemoveRss(linkDataEntity: LinkDataEntity) {
                    presenter.onRemoveLinkDataEntity(linkDataEntity)
                }
            }
        }

        if (childFragment is EditDialog && childFragment.tag == TAG_EDIT_DIALOG ) {
            childFragment.listener = object : EditDialog.OnEditListener {
                override fun onEditRss(linkDataEntity: LinkDataEntity) {
                    presenter.onUpdateLinkDataEntity(linkDataEntity)
                }
            }
        }
    }

    override fun showRssList(list: List<LinkDataEntity>) {
        rssAdapter.list = list
    }
    override fun showAddDialog() {
        val dialog: AddDialog = AddDialog.getInstance()
        dialog.show(childFragmentManager, TAG_ADD_DIALOG)
    }

    override fun showActionDialog(linkDataEntity: LinkDataEntity) {
       val dialog: ActionDialog = ActionDialog.getInstance(linkDataEntity)
        dialog.show(childFragmentManager, TAG_ACTION_DIALOG)
    }

    override fun showEditDialog(linkDataEntity: LinkDataEntity) {
        val dialog: EditDialog = EditDialog.getInstance(linkDataEntity)
        dialog.show(childFragmentManager, TAG_EDIT_DIALOG)
    }
}