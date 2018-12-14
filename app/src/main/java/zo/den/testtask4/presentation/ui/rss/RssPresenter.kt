package zo.den.testtask4.presentation.ui.rss

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.net.Uri
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl
import ru.terrakok.cicerone.Router
import zo.den.testtask4.Const
import zo.den.testtask4.data.dao.RssDao
import zo.den.testtask4.presentation.ScreenFactory
import zo.den.testtask4.presentation.base.MoxyPresenter
import zo.den.testtask4.presentation.mapper.RssModelMapper
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
        viewState.showRssList(rssDao.getRss())
    }


}