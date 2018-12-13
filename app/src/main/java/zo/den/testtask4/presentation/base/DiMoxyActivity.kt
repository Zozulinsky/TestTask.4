package zo.den.testtask4.presentation.base

import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import zo.den.testtask2.presentation.base.MoxyActivity
import javax.inject.Inject

abstract class DiMoxyActivity : MoxyActivity(), HasSupportFragmentInjector{
    @field:Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }
}