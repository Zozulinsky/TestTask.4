package zo.den.testtask4.presentation.ui

import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator


@Module(includes = [MainFragmentBuilder::class])
class MainModule {

    @Provides
    @MainQualifier
    @MainScope
    fun provideCicerone(@MainQualifier router: Router): Cicerone<Router> = Cicerone.create(router)

    @Provides
    @MainQualifier
    fun provideNavigatorHolder(@MainQualifier cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @MainQualifier
    fun provideNavigator(mainActivity: MainActivity): Navigator =
            SupportAppNavigator(mainActivity, mainActivity.containerId)

}