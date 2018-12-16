package zo.den.testtask4.presentation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zo.den.testtask4.presentation.dialog.AddDialog
import zo.den.testtask4.presentation.ui.MainActivity
import zo.den.testtask4.presentation.ui.MainModule
import zo.den.testtask4.presentation.ui.MainScope

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    @MainScope
    abstract fun buildMainActivity(): MainActivity

}