package zo.den.testtask4.presentation.ui.rss

import android.database.sqlite.SQLiteDatabase
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import zo.den.testtask4.data.dao.RssDao
import zo.den.testtask4.data.database.LinkDB
import zo.den.testtask4.data.database.LinkSQLiteOpenHelper
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

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val sqlOpenHelper: LinkSQLiteOpenHelper = LinkSQLiteOpenHelper(this.context)
        val db: SQLiteDatabase? = sqlOpenHelper.writableDatabase
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

    fun onRss(linkDataEntity: LinkDataEntity){
        router.navigateTo(ScreenFactory.getContentScreen(linkDataEntity.name, linkDataEntity.link))
    }


}