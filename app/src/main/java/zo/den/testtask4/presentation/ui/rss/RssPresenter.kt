package zo.den.testtask4.presentation.ui.rss

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import zo.den.testtask4.data.dao.RssDao
import zo.den.testtask4.data.database.LinkDB
import zo.den.testtask4.data.entity.LinkDataEntity
import zo.den.testtask4.presentation.ScreenFactory
import zo.den.testtask4.presentation.base.MoxyPresenter
import zo.den.testtask4.presentation.ui.MainQualifier
import javax.inject.Inject

@InjectViewState
class RssPresenter @Inject constructor() : MoxyPresenter<RssView>() {

    @field:Inject
    lateinit var rssDao: RssDao

    @Inject
    @field:MainQualifier
    lateinit var router: Router

    @field:Inject
    lateinit var linkDB: LinkDB

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getRss()

    }

    fun onRss(linkDataEntity: LinkDataEntity){
        router.navigateTo(ScreenFactory.getContentScreen(linkDataEntity.name, linkDataEntity.link))
    }

    fun onRssLong(linkDataEntity: LinkDataEntity){
        router.navigateTo(ScreenFactory.getContentScreen(linkDataEntity.name, linkDataEntity.link))
    }

    fun addRss(name: String, link: String){
        val linkDataEntity: LinkDataEntity? = LinkDataEntity(null, name, link)
        if (linkDataEntity != null) {
            linkDB.insertLink(linkDataEntity)
        }
        getRss()
    }

    fun getRss(){
        rssDao.getRssLinks()
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            viewState.showRssList(it)
                        },{
                }
                ).toCompositeDisposable()
    }


}