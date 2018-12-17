package zo.den.testtask4.presentation.ui.content

import android.content.Intent
import android.net.Uri
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl
import ru.terrakok.cicerone.Router
import zo.den.testtask4.data.dao.ContentDao
import zo.den.testtask4.data.entity.ChannelItemEntity
import zo.den.testtask4.presentation.base.MoxyPresenter
import zo.den.testtask4.presentation.ui.MainQualifier
import javax.inject.Inject
@InjectViewState
class ContentPresenter @Inject constructor() : MoxyPresenter<ContentView>() {

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
        update()
    }

    fun onContent(channelItemEntity: ChannelItemEntity) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(channelItemEntity.link))
        viewState.openBrowser(intent)
    }

    fun onUpdate() {
        update()
    }

    private fun update() {
        val httpUrl: HttpUrl? = HttpUrl.parse(link)
        if (httpUrl!=null){
            contentDao.getRss(httpUrl)
                    .toList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        viewState.showProgress()
                    }
                    .doAfterTerminate {
                        viewState.hideProgress()
                    }
                    .subscribe(
                            {
                                viewState.showContentList(it)
                            }, {
                        viewState.showNoConnection()
                    }
                    ).toCompositeDisposable()}
        else {viewState.showNoConnection()}
    }
}