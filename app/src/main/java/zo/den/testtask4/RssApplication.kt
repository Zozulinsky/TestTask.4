package zo.den.testtask4

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import zo.den.testtask4.di.DaggerAppComponent

class RssApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .application(this)
                .create(this)
    }

    override fun onCreate() {
        super.onCreate()
    }
}