package zo.den.testtask4.di

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import zo.den.testtask4.presentation.ui.MainQualifier
import javax.inject.Singleton

@Module
class RouterModule {

    @Provides
    @MainQualifier
    @Singleton
    fun provideMainRouter(): Router = Router()
}