package zo.den.testtask4.data

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import zo.den.testtask4.data.util.CacheInterceptor
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient = OkHttpClient.Builder()
            .cache(Cache(context.cacheDir, 10 * 1024 * 1024))
            .addNetworkInterceptor(CacheInterceptor(context))
            .build()
}