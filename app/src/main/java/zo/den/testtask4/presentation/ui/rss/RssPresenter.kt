package zo.den.testtask4.presentation.ui.rss

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import zo.den.testtask4.data.dao.RssDao
import zo.den.testtask4.presentation.base.MoxyPresenter
import zo.den.testtask4.presentation.mapper.RssModelMapper
import zo.den.testtask4.presentation.ui.MainQualifier
import javax.inject.Inject

@InjectViewState
class RssPresenter @Inject constructor() : MoxyPresenter<RssView>(){
    //TODO редактировать список RSS и после пополнения обновить отображаемые RSS
    var linkRss: String = "http://www.calend.ru/img/export/calend.rss/"

    @field:Inject
    lateinit var rssDao: RssDao

    @Inject
    @field:MainQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()



        rssDao.getRss()
                .map(RssModelMapper())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.showRssList(it)
                },{
                    it.printStackTrace()
                }).toCompositeDisposable()

}}