package zo.den.testtask4.presentation.base

import android.content.Context
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class MoxyPresenter <T: MvpView>: MvpPresenter<T>(){
    protected var destroyDisposable = CompositeDisposable()
    protected lateinit var context: Context

    override fun onDestroy(){
        super.onDestroy()
        if (!destroyDisposable.isDisposed)
            destroyDisposable.dispose()
    }

    protected fun Disposable.toCompositeDisposable(): Boolean{
        return destroyDisposable.add(this)
    }
}