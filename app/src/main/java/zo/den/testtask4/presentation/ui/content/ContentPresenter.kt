package zo.den.testtask4.presentation.ui.content

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl
import ru.terrakok.cicerone.Router
import zo.den.testtask4.data.dao.ContentDao
import zo.den.testtask4.data.dao.RssDao
import zo.den.testtask4.data.entity.ChannelItemEntity
import zo.den.testtask4.presentation.base.MoxyPresenter
import zo.den.testtask4.presentation.ui.MainQualifier
import javax.inject.Inject

@InjectViewState
class ContentPresenter @Inject constructor() : MoxyPresenter<ContentView>(){

    @field:Inject
    @field:ContentQualifier("linkRss")
    lateinit var link: String

    @field:Inject
    lateinit var contentDao: ContentDao

    @Inject
    @field:MainQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        //TODO добавить проверку линка
        contentDao.getRss(HttpUrl.parse(link)!!)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            viewState.showContentList(it)
                        },{
                }
                ).toCompositeDisposable()
    }

    fun onContent(channelItemEntity: ChannelItemEntity){
        //TODO добавить логику открытия WebView при наличии ссылки
    }
}