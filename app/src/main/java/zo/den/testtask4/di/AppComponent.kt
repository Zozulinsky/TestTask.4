package zo.den.testtask4.di

import android.app.Application
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import zo.den.testtask4.RssApplication
import zo.den.testtask4.data.DataModule
import zo.den.testtask4.presentation.ActivityBuilder
import zo.den.testtask4.presentation.ui.rss.RssModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataModule::class,
    RouterModule::class,
    RssModule::class,
    ActivityBuilder::class,
    AppModule::class,
    AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<RssApplication>{
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<RssApplication>() {
        @BindsInstance
        abstract fun application(application: Application): Builder
    }
}

