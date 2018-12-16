package zo.den.testtask4.presentation.ui.rss

import android.content.Context
import android.support.design.widget.Snackbar
import android.webkit.URLUtil
import android.widget.Toast
import com.arellomobile.mvp.InjectViewState
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import zo.den.testtask4.R
import zo.den.testtask4.data.dao.RssDao
import zo.den.testtask4.data.database.LinkDB
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.ScreenFactory
import zo.den.testtask4.presentation.base.MoxyPresenter
import zo.den.testtask4.presentation.dialog.AddDialog
import zo.den.testtask4.presentation.ui.MainQualifier
import javax.inject.Inject

@InjectViewState
class RssPresenter @Inject constructor() : MoxyPresenter<RssView>() {

    @field:Inject
    lateinit var rssDao: RssDao

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

    fun onAddRss(name: String, link: String) {
        val linkDataEntity = LinkDataEntity(null, name, link)
        rssDao.addRssLink(linkDataEntity)
                .andThen(rssDao.getRssLinks())
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
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

    fun onUpdateLinkDataEntity(linkDataEntity: LinkDataEntity) {
        rssDao.updateRssLink(linkDataEntity)
                .andThen(rssDao.getRssLinks())
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    fun onOpenEditLinkDialog(linkDataEntity: LinkDataEntity) {
        viewState.showEditDialog(linkDataEntity)
    }


}