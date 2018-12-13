package zo.den.testtask4.data

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import zo.den.testtask4.data.network.RssServiceModule
import zo.den.testtask4.data.network.Service.RssService
import javax.inject.Singleton

@Module(includes = [RssServiceModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
}