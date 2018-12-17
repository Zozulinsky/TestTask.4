package zo.den.testtask4.presentation.ui.rss

import android.widget.TextView
import com.arellomobile.mvp.InjectViewState
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_add.*
import kotlinx.android.synthetic.main.dialog_edit.*
import okhttp3.HttpUrl
import ru.terrakok.cicerone.Router
import zo.den.testtask4.R
import zo.den.testtask4.data.dao.ContentDao
import zo.den.testtask4.data.dao.RssDao
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.ScreenFactory
import zo.den.testtask4.presentation.base.MoxyPresenter
import zo.den.testtask4.presentation.dialog.AddDialog
import zo.den.testtask4.presentation.dialog.EditDialog
import zo.den.testtask4.presentation.ui.MainQualifier
import javax.inject.Inject


@InjectViewState
class RssPresenter @Inject constructor() : MoxyPresenter<RssView>() {

    @field:Inject
    lateinit var rssDao: RssDao

    @field:Inject
    lateinit var contentDao: ContentDao

    @Inject
    @field:MainQualifier
    lateinit var router: Router

    private val observer = object : SingleObserver<List<LinkDataEntity>> {
        override fun onSuccess(t: List<LinkDataEntity>) {
            viewState.showRssList(t)
        }

        override fun onSubscribe(d: Disposable) {
            d.toCompositeDisposable()
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        rssDao.getRssLinks()
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    fun onRss(linkDataEntity: LinkDataEntity) {
        router.navigateTo(ScreenFactory.getContentScreen(linkDataEntity.name, linkDataEntity.link))
    }

    fun onRssLong(linkDataEntity: LinkDataEntity) {
        viewState.showActionDialog(linkDataEntity)
    }

    fun onAddRss(dialog: AddDialog, name: String, link: String) {
        if (name.length == 0) {
            dialog.text_checkRss.setText(R.string.check_nameRSS)
            dialog.text_checkRss.visibility = TextView.VISIBLE
        } else {
            dialog.text_checkRss.visibility = TextView.INVISIBLE
            if (link.length == 0) {
                dialog.text_checkRss.setText(R.string.check_urlRSS)
                dialog.text_checkRss.visibility = TextView.VISIBLE
            } else {
                HttpUrl.parse(link)?.let {
                    contentDao.checkRss(it)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                if (it.body()?.contentType()?.subtype() == "rss+xml") {
                                    dialog.text_checkRss.visibility = TextView.INVISIBLE
                                    dialog.dismiss()
                                    val linkDataEntity = LinkDataEntity(null, name, link)
                                    rssDao.addRssLink(linkDataEntity)
                                            .andThen(rssDao.getRssLinks())
                                            .toList()
                                            .subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(observer)
                                } else {
                                    dialog.text_checkRss.setText(R.string.check_RSS)
                                    dialog.text_checkRss.visibility = TextView.VISIBLE
                                }
                            }, {
                                dialog.text_checkRss.setText(R.string.check_RSS)
                                dialog.text_checkRss.visibility = TextView.VISIBLE
                                it.printStackTrace()
                            }).toCompositeDisposable()
                }
            }
        }
    }

    fun onShowAddDialog() {
        viewState.showAddDialog()
    }

    fun onRemoveLinkDataEntity(linkDataEntity: LinkDataEntity) {
        rssDao.removeRssLink(linkDataEntity)
                .andThen(rssDao.getRssLinks())
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    fun onUpdateLinkDataEntity(dialog: EditDialog, linkDataEntity: LinkDataEntity) {
        if (linkDataEntity.name.length == 0) {
            dialog.text_checkEditRss.setText(R.string.check_nameRSS)
            dialog.text_checkEditRss.visibility = TextView.VISIBLE
        } else {
            dialog.text_checkEditRss.visibility = TextView.INVISIBLE
            if (linkDataEntity.link.length == 0) {
                dialog.text_checkRss.setText(R.string.check_urlRSS)
                dialog.text_checkRss.visibility = TextView.VISIBLE
            } else {
                HttpUrl.parse(linkDataEntity.link)?.let {
                    contentDao.checkRss(it)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                if (it.body()?.contentType()?.subtype() == "rss+xml") {
                                    dialog.text_checkEditRss.visibility = TextView.INVISIBLE
                                    dialog.dismiss()
                                    rssDao.updateRssLink(linkDataEntity)
                                            .andThen(rssDao.getRssLinks())
                                            .toList()
                                            .subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(observer)
                                } else {
                                    dialog.text_checkEditRss.setText(R.string.check_RSS)
                                    dialog.text_checkEditRss.visibility = TextView.VISIBLE
                                }
                            }, {
                                dialog.text_checkEditRss.setText(R.string.check_RSS)
                                dialog.text_checkEditRss.visibility = TextView.VISIBLE
                                it.printStackTrace()
                            }).toCompositeDisposable()
                }
            }
        }
    }

    fun onOpenEditLinkDialog(linkDataEntity: LinkDataEntity) {
        viewState.showEditDialog(linkDataEntity)
    }
}