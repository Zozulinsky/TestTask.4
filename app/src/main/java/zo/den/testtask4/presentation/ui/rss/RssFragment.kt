package zo.den.testtask4.presentation.ui.rss

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.rv_rss.*
import zo.den.testtask4.R
import zo.den.testtask4.data.database.LinkDB
import zo.den.testtask4.data.database.LinkSQLiteOpenHelper
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.adapter.RssAdapter
import zo.den.testtask4.presentation.base.MoxyFragment
import zo.den.testtask4.presentation.dialog.AddDialog
import javax.inject.Inject
import javax.inject.Provider

class RssFragment : MoxyFragment(), RssView {

    companion object {
        fun getInstance(): RssFragment = RssFragment()
    }

    override val layout: Int = R.layout.rv_rss

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
        val context: Context? = this.context
        rss_list.adapter = rssAdapter
        rss_list.layoutManager = LinearLayoutManager(context)
        rssAdapter.listener = object : RssAdapter.OnItemClickListener {
            override fun onItemClick(linkDataEntity: LinkDataEntity) {
                    presenter.onRss(linkDataEntity)
            }

            override fun onItemLongClick(linkDataEntity: LinkDataEntity) {

            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        if (childFragment is AddDialog && childFragment.tag == "add_rss") {
            childFragment.listener = object : AddDialog.OnAddListener {
                override fun onAddRss() {
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.rss_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add) {
            showAddDialog(AddDialog())
        }

        return super.onOptionsItemSelected(item)

    }

    override fun showRssList(list: List<LinkDataEntity>) {
            rssAdapter.list = list


    }

    fun showAddDialog(dialog: AddDialog){
        dialog.show(childFragmentManager, "add_rss")
    }


}